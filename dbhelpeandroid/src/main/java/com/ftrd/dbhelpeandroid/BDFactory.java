package com.ftrd.dbhelpeandroid;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jay on 2017/9/12 0012.
 * 使用该工厂, 传入对象即可，
 * 如果是太复杂的语句可以自己写sql语句处理
 */

public class BDFactory<T> {
    /**
     * 数据库信息
     */
    private int mDbVersion=1;//版本
    private String mDbName="mData.db";//数据库名
    /**
     * 创建表语句
     */
    private String[] mDbCreateSql;
    //初始化工厂对象，也就是创建数据库，创建表
    public long init(String tableName,int mDbVersion,T tabes){
        //创建数据库

        return 1;
    }




    private T bean;//操作的bean对象

    public BDFactory(T bean) {
        this.bean = bean;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }



    private ArrayList<Field> fieldArray; //存储 bean对象的成员变量的集合

    private String primaryKey;//主键在bean中属性的名称
    private SQLite sqLite;

    public void show(T object) {
        List<Map> list = sqLite.queryListMap("select * from user", null);
        // contentTv.setText(String.valueOf(list));
        //使用Gson将json字符串转为map
        Map<String, Object> map = new Gson().fromJson(String.valueOf(object), new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }

    public long CDDATABASE(String dataBaseName) {
        return 1;
    }

    /**
     * +---------+---------------+------+-----+---------+-------+
     * | Field   | Type          | Null | Key | Default | Extra |
     * +---------+---------------+------+-----+---------+-------+
     * | ID      | int(11)       | NO   | PRI |         |       |
     * | NAME    | varchar(20)   | NO   |     |         |       |
     * | AGE     | int(11)       | NO   |     |         |       |
     * | ADDRESS | char(25)      | YES  |     | NULL    |       |
     * | SALARY  | decimal(18,2) | YES  |     | NULL    |       |
     * +---------+---------------+------+-----+---------+-------+
     * 创建表,只能创建一些简单的表，如果要创建很复杂的表则可以自己写SQL语句
     * 在这里只能创建一个简单的varchar(50)
     *
     * @param tabe   表名 String
     * @param create 表里的字段
     * @return 创建表成功id long
     */

    public long create(String tabe, T create) {
        return 1;
    }

    /**
     * 插入数据
     *
     * @param insert 要插入的bean
     * @return 插入数据的id long
     */
    public long insert(T insert) {
        return 1;
    }

    /**
     * 更新数据
     *
     * @param old   旧的数据bean
     * @param where 新的数据bean
     * @return long
     */
    public long update(T old, T where) {
        return 1;
    }

    /**
     * 普通查询
     *
     * @param where 要检索的bean
     * @return 结果集合 List<T>
     */
    public List<T> query(T where) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param where      要检索的bean
     * @param startIndex 查询起始下标 0开始
     * @param limit      查询个数
     * @return 结果集合 List<T>
     */
    public List<T> query(T where, Integer startIndex, Integer limit) {
        return null;
    }

    /**
     * 删除数据
     *
     * @param insert 删除的条件bean
     * @return 删除的id long
     */
    public long delete(T insert) {
        return 1;
    }

    /**
     * * +---------+---------------+------+-----+---------+-------+
     * | Field   | Type          | Null | Key | Default | Extra |
     * +---------+---------------+------+-----+---------+-------+
     * | ID      | int(11)       | NO   | PRI |         |       |
     * | NAME    | varchar(20)   | NO   |     |         |       |
     * | AGE     | int(11)       | NO   |     |         |       |
     * | ADDRESS | char(25)      | YES  |     | NULL    |       |
     * | SALARY  | decimal(18,2) | YES  |     | NULL    |       |
     * +---------+---------------+------+-----+---------+-------+
     * 创建很复杂的表则可以自己写SQL语句
     * 查询很复杂的表也可以自己写sql语句
     *
     * @param sql
     * @return Object
     */
    public Object sql(String sql) {
        return null;
    }

}
