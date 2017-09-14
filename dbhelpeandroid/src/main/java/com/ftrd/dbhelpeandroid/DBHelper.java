package com.ftrd.dbhelpeandroid;

import android.content.Context;

/**
 * Created by Jay on 2017/9/12 0012.
 */

public class DBHelper extends Helpear {

    private static DBHelper mTestDBHelper;

    public DBHelper(Context context) {
        super(context);
    }

    public static DBHelper getInstance(Context context) {
        if (mTestDBHelper == null) {
            synchronized (Helpear.class) {
                if (mTestDBHelper == null) {
                    mTestDBHelper = new DBHelper(context);
                    if (mTestDBHelper.getDB() == null || !mTestDBHelper.getDB().isOpen()) {
                        mTestDBHelper.open();
                    }
                }
            }
        }
        return mTestDBHelper;
    }


    @Override
    protected String[] getDbCreateSql() {
        String[] a = new String[1];
        a[0] = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,gender TEXT,age INTEGER)";
        return a;
    }

    @Override
    protected String[] getDbUpdateSql( ) {
        return new String[0];
    }
}