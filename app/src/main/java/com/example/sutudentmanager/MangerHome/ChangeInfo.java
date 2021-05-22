package com.example.sutudentmanager.MangerHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sutudentmanager.R;
import com.example.sutudentmanager.SQLite.StudentSQlit;

public class ChangeInfo extends AppCompatActivity {
    private static final String dbFilefors = "student1.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);

        Button back = findViewById(R.id.button12);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StudentSQlit dbe = new StudentSQlit(getApplicationContext(),dbFilefors,null,1);
                SQLiteDatabase db = dbe.getWritableDatabase();

                String id = ((EditText)findViewById(R.id.editText6)).getText().toString();
                String name = ((EditText)findViewById(R.id.editText7)).getText().toString();
                String sex = ((EditText)findViewById(R.id.editText8)).getText().toString();
                String add = ((EditText)findViewById(R.id.editText9)).getText().toString();
                String pro = ((EditText)findViewById(R.id.editText10)).getText().toString();

                ContentValues values = new ContentValues();
                if(!id.isEmpty()){
                    if(!sex.isEmpty())
                        values.put("sex",sex);
                    if(!add.isEmpty())
                        values.put("address",add);
                    if(!pro.isEmpty())
                        values.put("profession",pro);
                }
                int result = db.update("student",values,"id=?",new String[]{id});
                Log.i("change",String.valueOf(result));

            }
        });


    }
}
