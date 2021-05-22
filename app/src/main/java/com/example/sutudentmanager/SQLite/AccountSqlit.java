package com.example.sutudentmanager.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountSqlit extends SQLiteOpenHelper {

    public AccountSqlit(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version){
        super(context,dbName,factory,version);
    }

    //创建数据表的语句
    private static final String sql = "create table if not exists account(" +
            "id varchar(10) not null primary key ," +
            "password varchar(20)," +
            "flag integer);" ;

    private static final String insert = "insert into account(id,password,flag) " +
            "values('manager','123',1);" ;

    private static final String insert2 = "insert into account(id,password,flag) " +
            "values('123','123',2);" ;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);    //执行sql语句 创建学生表
        db.execSQL(insert);
        db.execSQL(insert2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists account");
            onCreate(db);
    }
}
