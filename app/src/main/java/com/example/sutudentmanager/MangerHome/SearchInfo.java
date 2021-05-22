package com.example.sutudentmanager.MangerHome;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sutudentmanager.R;
import com.example.sutudentmanager.SQLite.StudentSQlit;

public class SearchInfo extends AppCompatActivity {
    private static final String dbFilefors = "student1.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_info);

        final View view = findViewById(R.id.sear);
//        final View view = this.getLayoutInflater().inflate(R.layout.activity_search_info,null);

        Button back = findViewById(R.id.button13);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button search = findViewById(R.id.button11);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ((TextView)findViewById(R.id.idforsearch)).getText().toString();


                StudentSQlit dbe = new StudentSQlit(getApplicationContext(),dbFilefors,null,1);
                SQLiteDatabase db = dbe.getWritableDatabase();


                Cursor record = db.rawQuery("select * from student where id = ?",new String[]{id});
                Log.i("search",id);


        //cursor读取数据
                if(record.moveToFirst()){
                    do{
                        ((TextView)view.findViewById(R.id.show_name)).setText(record.getString(1));
                        ((TextView)view.findViewById(R.id.show_sex)).setText(record.getString(2));
                        ((TextView)view.findViewById(R.id.show_add)).setText(record.getString(3));
                        ((TextView)view.findViewById(R.id.show_pro)).setText(record.getString(4));
                    }while(record.moveToNext());

                }
                else
                    Toast.makeText(getApplicationContext(),"no such student",Toast.LENGTH_SHORT).show();




                db.close();

            }
        });
    }
}
