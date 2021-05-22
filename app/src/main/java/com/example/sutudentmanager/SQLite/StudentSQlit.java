package com.example.sutudentmanager.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//学生表的数据库类
public class StudentSQlit extends SQLiteOpenHelper {

    public StudentSQlit(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version){
        super(context,dbName,factory,version);
    }

    //创建数据表的语句
    private static final String sql = "create table if not exists student(" +
            "id varchar(10) not null primary key," +
            "name varchar(10)," +
            "sex varchar(5)," +
            "address varchar(100)," +
            "profession varchar(20));" ;

    private static final String insert = "insert into student " +
            "values('123','xs','man','addresss','professiond');";
    //数据库的初始化操作，创建基本的数据表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);    //执行sql语句 创建学生表
        db.execSQL(insert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }
}
