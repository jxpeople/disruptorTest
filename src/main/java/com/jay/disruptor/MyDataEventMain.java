package com.jay.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description
 * Created by caoyj on 2018/7/5.
 */
public class MyDataEventMain {

    public static void main(String[] args) {
        // step1 : 创建缓冲池
        ExecutorService executor = Executors.newCachedThreadPool();
        // step2 : 创建工厂
        MyDataEventFactory factory = new MyDataEventFactory();
        // step3 : 创建bufferSize ,也就是RingBuffer大小，必须是2的N次方
        int ringBufferSize = 1024 * 1024;

        // step4 : 创建disruptor
        Disruptor<MyDataEvent> disruptor = new Disruptor<MyDataEvent>(factory, ringBufferSize, executor);

        // step5 : 连接消费事件方法<消费者>
        disruptor.handleEventsWith(new MyDataEventHandler());

        // step6 : 启动
        disruptor.start();

        RingBuffer<MyDataEvent> ringBuffer = disruptor.getRingBuffer(); // 获取 ringBuffer

        // step7 : 生产者发布事件
        MyDataEventProducer producer = new MyDataEventProducer(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(128); // 创建一个容量为128字节的ByteBuffer

        for (long data = 1; data <= 10000 ; data++) { // 不管是打印100，1000，10000，基本上都是一秒内输出。
            byteBuffer.putLong(0, data); // 在下标为零的位置存储值
            producer.publishData(byteBuffer); //
        }

        disruptor.shutdown(); // 关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
        executor.shutdown(); // 关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
    }



}
