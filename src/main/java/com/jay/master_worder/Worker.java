package com.jay.master_worder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Description
 * Created by caoyj on 2018/7/6.
 */
public class Worker  implements Runnable {

    private ConcurrentLinkedQueue<Task> workQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while(true){
            Task input = this.workQueue.poll(); // 从头部取出元素，并从队列里删除
            if(input == null) break;
            Object output = handle(input);
            this.resultMap.put(input.getId().toString(), output); // key是对象id，value是对象price
        }
    }

    private Object handle(Task input) {
        Object output = null;
        try {
            //处理任务的耗时。。 比如说进行操作数据库。。。
            Thread.sleep(500);
            output = input.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }

}
