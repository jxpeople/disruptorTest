package com.jay;

import com.lmax.disruptor.EventHandler;

/**
 * 第三步：消费端
 *  * EventHandler：消费者，也可以理解为事件处理器
 * Created by caoyj on 2018/7/5.
 */
public class MyDataEventHandler implements EventHandler<MyDataEvent> {

    public void onEvent(MyDataEvent myDataEvent, long l, boolean b) throws Exception {
        // 处理事件 ....
        System.out.println("处理事件，打印数据： " + myDataEvent.getValue());
    }
}
