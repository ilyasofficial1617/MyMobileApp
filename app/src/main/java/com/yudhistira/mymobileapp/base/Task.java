package com.yudhistira.mymobileapp.base;

import java.io.Serializable;

public class Task implements Serializable {


    private Integer id;
    private String name;
    private String detail;
    private boolean done;

    public Task(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public Task(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public boolean isDone() { return done; }

    public void setDone(boolean done) { this.done = done; }
}
