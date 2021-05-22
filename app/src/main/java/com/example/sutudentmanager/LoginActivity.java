package com.example.sutudentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sutudentmanager.Home.Home;
import com.example.sutudentmanager.Home.StudentHome;
import com.example.sutudentmanager.SQLite.AccountSqlit;

public class LoginActivity extends AppCompatActivity {

    //数据库名称

    private static final String dbFilefora = "account1.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button login = findViewById(R.id.login);
        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase db = openOrCreateDatabase("dbFilefora",MODE_PRIVATE,null);

//                String DATABASE_PATH = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
//                String databaseFilename = DATABASE_PATH + "/" + "account.db";
//                SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(databaseFilename,null);

                AccountSqlit dbe = new AccountSqlit(getApplicationContext(),dbFilefora,null,1);
                SQLiteDatabase db = dbe.getWritableDatabase();

                EditText account = findViewById(R.id.account);
                String acc =  account.getText().toString();
                EditText password = findViewById(R.id.password);
                String pass = password.getText().toString();

//                执行查询语句将结果记录在游标中
                Cursor record = db.rawQuery("select * from account where id = ?;",new String[]{acc});

//              如果密码正确打开首页界面
                if(record.moveToFirst()){
                    do{
                        String first = record.getString(0).toString();

                        Log.i("s",record.getString(0));
                        Log.i("s",pass);

                        if (record.getInt(2) == 1){
                            Toast.makeText(getApplicationContext(),"manager login",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Home.class);
                            startActivity(intent);
                        }
                        else if (record.getInt(2) == 2){
                            Toast.makeText(getApplicationContext(),"user login",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), StudentHome.class);

//                            保存id为了后面学生修改自己的信息不用再输入自己的学号 默认自己的账号就是学号
                            Bundle bundle = new Bundle();
                            bundle.putCharSequence("id",record.getString(0));
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }





//                        if(first == pass){
//                            Log.i("s","donga ");
//                            Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(),Home.class);
//
//                            startActivity(intent);
//                        }
                    }while(record.moveToNext());
                }
                db.close();
                dbe.close();
            }
        });



    }


}
