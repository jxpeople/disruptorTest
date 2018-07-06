package com.jay.featuretest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Future模式的JDK内置实现
 * Created by caoyj on 2018/7/5.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        FutureTask futureTask =
                new FutureTask(new RealData("name"));
        ExecutorService executor =
                Executors.newFixedThreadPool(1); //使用线程池
        //执行FutureTask，相当于上例中的client.request("name")发送请求
        executor.submit(futureTask);
        //这里可以用一个sleep代替对其他业务逻辑的处理
        //在处理这些业务逻辑过程中，RealData也正在创建，从而充分了利用等待时间
        Thread.sleep(2000);
        //使用真实数据
        //如果call()没有执行完成依然会等待
        System.out.println("数据=" + futureTask.get());
    }
}
