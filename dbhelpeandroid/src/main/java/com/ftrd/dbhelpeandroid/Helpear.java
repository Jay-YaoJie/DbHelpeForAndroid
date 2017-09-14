package com.ftrd.dbhelpeandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jeff on 2017/9/12 0012.
 * 包含了进行数据库操作要用到的各种信息，并且在初始化的进行了赋值。同时还提供了SQLiteDatabase的open、close。
 * 同时在这里用到了抽象方法是因为考虑创建多个数据库的情况，让子类来提供具体的数据库信息，我只管做创建和操作就行了。
 */

public abstract class Helpear {
    /**
     * 用来创建和获取数据库的SQLiteOpenHelper
     */
    protected DBHelper mDbHelper;
    /**
     * 数据库对象
     */
    protected SQLiteDatabase mDb;

    /**
     * 数据库信息
     */
    protected int mDbVersion=1;//版本
    protected String mDbName="mData.db";//数据库名
    /**
     * 创建表语句
     */
    private String[] mDbCreateSql;
    /**
     * 更新表语句
     */
    private String[] mDbUpdateSql;
    protected abstract String[] getDbCreateSql();
    protected abstract String[] getDbUpdateSql();
    public Helpear(Context context) {
        this.mDbCreateSql = this.getDbCreateSql();
        this.mDbUpdateSql = this.getDbUpdateSql();
        this.mDbHelper = new DBHelper(context,this.mDbName,null,this.mDbVersion);
    }

    protected void open(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mDb = mDbHelper.getWritableDatabase();
            }
        }).start();

    }

    protected SQLiteDatabase getDB(){
        return this.mDb;
    }


    public void close(){
        this.mDb.close();
        this.mDbHelper.close();
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String[] arr = Helpear.this.mDbCreateSql;
            //执行创建表语句
            for (int i = 0; i < arr.length; i++) {
                String sql = arr[i];
                db.execSQL(sql);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String[] arr = Helpear.this.mDbUpdateSql;
            //执行更新语句
            for (int i = 0; i < arr.length; i++) {
                String sql = arr[i];
                db.execSQL(sql);
            }
        }
    }
}
