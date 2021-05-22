package com.example.sutudentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sutudentmanager.SQLite.AccountSqlit;
import com.example.sutudentmanager.SQLite.StudentSQlit;


public class MainActivity extends AppCompatActivity {

    //数据库名称
    private static final String dbFilefors = "student1.db";
    private static final String dbFilefora = "account1.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化数据库
        StudentSQlit dbe = new StudentSQlit(this,dbFilefors,null,1);
        //SQLiteDatabase db = dbe.getWritableDatabase();
        //查询数据
//        Cursor records = db.rawQuery("sqlyuju");
//        StringBuilder sb = new StringBuilder();
//        if(records.moveToFirst()){
//            do{
//                sb.append(records.getString(0));
//            }while(records.moveToNext())
//        }
  //      db.close();
        dbe.close();

        //初始化数据库
        AccountSqlit db = new AccountSqlit(this,dbFilefora,null,1);
        db.close();

        Button btn = findViewById(R.id.button);
        final Intent intent = new Intent(this, LoginActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
