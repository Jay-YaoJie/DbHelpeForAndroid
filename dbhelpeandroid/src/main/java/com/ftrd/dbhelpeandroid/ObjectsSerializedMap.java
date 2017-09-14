package com.ftrd.dbhelpeandroid;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jay on 2017/9/13 0013.
 * T对象转换成amp对象
 * 或者map对象转换为T对象
 * <p>
 * user to map or map to user
 */

public class ObjectsSerializedMap<T> {
    private T object;
    private Gson gson;

    /**
     * 把T对象转换为Map对象
     *
     * @param tClass T对象
     * @return Map<Object,Object>
     */
    public Map<Object, Object> getObjectMap(T tClass) {
        try {
            if (gson == null) {
                gson = new Gson();
            }
            String jsonStr = gson.toJson(tClass);
            return gson.fromJson(jsonStr, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Map对象转换为T对象
     *
     * @param objectMap 　Map<Object, Object>对象
     * @param object    　Class<T> 对象
     * @return T对象
     */
    public T getT(Map<Object, Object> objectMap, Class<T> object) {
        try {
            //        //"通过Map.entrySet遍历key和value"   尤其是容量大时(相对来说 比2好一点 效率高)
//        for (Map.Entry<Object, Object> entry : objectMap.entrySet()) {
//            Field[] fields = object.getDeclaredFields();
//            if ("$change".equals(fields[1].getName())
//                    || "serialVersionUID".equals(fields[1].getName())) {//这是什么鬼...不知道,应该是install run的差分编译原因
            //如果想用此方法可以去自己把对象里的属性一个一个的添加
//                continue;
//            }
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//        }
            if (gson == null) {
                gson = new Gson();
            }
            String jsonStr = gson.toJson(objectMap);
            return gson.fromJson(jsonStr, object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    List<T> tList = null;

    /**
     * 把对象转换为list对象
     *
     * @param tClass
     * @return
     */
    public List<T> setListT(T tClass) {
//      try {
//          if (gson==null){
//              gson = new Gson();
//          }
//          String jsonStr = gson.toJson(tClass);//{"user":"4","ids":"3","avg":"2"}
//          jsonStr="["+jsonStr+"]";
//        //  [{"name":"name0","age":0}]//list数据、、[{"name":"name0","age":0}][{"name":"name1","age":5}][{"name":"name2","age":10}]
//          return gson.fromJson(jsonStr,new TypeToken<List<T>>(){}.getType());
//      }catch (Exception e){
//          e.printStackTrace();
//          return null;
//      }
        try {
            if (tList == null) {
                tList = new ArrayList<T>();
            }
            tList.add(tClass);
            return tList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获得单个T对象
     * @return T 对象
     */
    public T getObjectList() {
        try {
            if (tList != null && tList.size() > 0) {
                return tList.get(0);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
