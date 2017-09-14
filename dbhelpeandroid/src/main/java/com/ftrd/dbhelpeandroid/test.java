package com.ftrd.dbhelpeandroid;

/**
 * Created by Jay on 2017/9/13 0013.
 */
import com.google.gson.*;

import junit.framework.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: chuang.liu
 * Date: 11-7-21
 * Time: 下午3:50
 * To change this template use File | Settings | File Templates.
 */
public class test {
    private int data;
    private Map<String,Object> mapData;
    public void setData(int data){
        this.data =data;
    }

    public int getData(){
        return data;
    }

    public void setmapData(Map<String,Object> data){
        this.mapData =data;
    }

    public Map<String,Object> getmapData(){
        return mapData;

    }
    public static void main(String arg[]){


        Map<Object, Object> data = new HashMap<Object, Object>();

        ObjectsSerializedMap<user> objectsSerializedMap=new ObjectsSerializedMap<user>();
        user users=new user();
        users.setNames("1");
        users.setAvg("2");
        users.setIds("3");
        users.setUser("4");
        data= objectsSerializedMap.getObjectMap(users);
        System.out.println("data=="+data.toString());

       // t.setmapData(data);
       // String jstring = gson.toJson(t);
         users=null;
        data.remove("names");
        users= objectsSerializedMap.getT(data,user.class);
        System.out.println("users=="+users);
        List<user>listT= objectsSerializedMap.setListT(users);
        System.out.print("");
    }
}