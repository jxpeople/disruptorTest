package com.jay.featuretest;

import java.util.concurrent.Callable;

/**
 * Description
 * Created by caoyj on 2018/7/5.
 */
public class RealData implements Callable {
    protected String data;

    public RealData(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        //利用sleep方法来表示真是业务是非常缓慢的
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }
}
