package com.jay.master_worder;

/**
 * Description
 * Created by caoyj on 2018/7/6.
 */
public class Task {

    private Integer id;
    private Integer price;

    public Task() {}

    public Task(Integer id, Integer price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
