package com.jay.master_worder;

/**
 * Description
 * Created by caoyj on 2018/7/6.
 */
public class Main {

    public static void main(String[] args) {

        Master master = new Master(new Worker(), 100);
        // 对象赋值
        for (int i = 1; i <= 100; i++) {
            Task t = new Task();
            t.setId(i);
            t.setPrice(i * 10);
            master.submit(t);
        }

        // Master启动worker去执行任务
        master.execute();
        long start = System.currentTimeMillis();
        while(true){
            // 判断Worker子任务是否全部执行成功
            if(master.isComplete()){
                int priceResult = master.getResult(); // 获得master 收集总结的值
                long end = System.currentTimeMillis() - start;
                System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
                break;
            }
        }


    }
}
