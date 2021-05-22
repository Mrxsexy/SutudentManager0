package com.example.sutudentmanager.MangerHome;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sutudentmanager.R;
import com.example.sutudentmanager.SQLite.StudentSQlit;

public class AddStudent extends AppCompatActivity {

    private static final String dbFilefors = "student1.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        Button back = findViewById(R.id.button9);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button addstd = findViewById(R.id.button8);
        addstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentSQlit dbe = new StudentSQlit(getApplicationContext(),dbFilefors,null,1);
                SQLiteDatabase db = dbe.getWritableDatabase();

                String sql = "insert into student " +
                        "values(?,?,?,?,?);";

                String id = ((EditText)findViewById(R.id.editText)).getText().toString();
                String name = ((EditText)findViewById(R.id.editText2)).getText().toString();
                String sex = ((EditText)findViewById(R.id.editText3)).getText().toString();
                String add = ((EditText)findViewById(R.id.editText4)).getText().toString();
                String pro = ((EditText)findViewById(R.id.editText5)).getText().toString();
                db.execSQL(sql,new String[]{id,name,sex,add,pro});
            }
        });





    }


}
