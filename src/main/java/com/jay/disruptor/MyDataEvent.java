package com.jay.disruptor;

/**
 第一步：创建一个数据单元Event
 * Event：从生产者到消费者过程中所处理的数据单元
 * Created by caoyj on 2018/7/5.
 */

public class MyDataEvent {
    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
