package com.example.sutudentmanager.MangerHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sutudentmanager.R;
import com.example.sutudentmanager.SQLite.StudentSQlit;

public class ChangeInfoforself extends AppCompatActivity {
    private static final String dbFilefors = "student1.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_infoforself);

        Button back = findViewById(R.id.selfback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button change = findViewById(R.id.changeforself);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StudentSQlit dbe = new StudentSQlit(getApplicationContext(),dbFilefors,null,1);
                SQLiteDatabase db = dbe.getWritableDatabase();


                String name = ((EditText)findViewById(R.id.editText11)).getText().toString();
                String sex = ((EditText)findViewById(R.id.editText12)).getText().toString();
                String add = ((EditText)findViewById(R.id.editText13)).getText().toString();
                String pro = ((EditText)findViewById(R.id.editText14)).getText().toString();

                ContentValues values = new ContentValues();

                if (!name.isEmpty())
                    values.put("name",name);
                if(!sex.isEmpty())
                    values.put("sex",sex);
                if(!add.isEmpty())
                    values.put("address",add);
                if(!pro.isEmpty())
                    values.put("profession",pro);

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();

                String id = bundle.getString("id");

                int result = db.update("student",values,"id=?",new String[]{id});
                Log.i("change",String.valueOf(result));

            }
        });


    }

}
