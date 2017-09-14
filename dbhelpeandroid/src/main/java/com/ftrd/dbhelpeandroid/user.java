package com.ftrd.dbhelpeandroid;

/**
 * Created by Jay on 2017/9/13 0013.
 */

public class user {

    public String user;//="id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,gender TEXT,age INTEGER";

    public String names;//="id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,gender TEXT,age INTEGER";
    public String ids;//="id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,gender TEXT,age INTEGER";
    public String avg;//="id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,gender TEXT,age INTEGER";

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }
}
