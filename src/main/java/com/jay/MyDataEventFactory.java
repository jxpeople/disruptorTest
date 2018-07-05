package com.jay;

import com.lmax.disruptor.EventFactory;

/**
 *  * 第二步创建工厂类实例化Event
 *  * EventFactory 工厂，用于实例化Event类
 * Created by caoyj on 2018/7/5.
 */
public class MyDataEventFactory  implements EventFactory<MyDataEvent> {

    public MyDataEvent newInstance() {
        return new MyDataEvent();
    }
}
