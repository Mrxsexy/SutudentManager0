package com.example.sutudentmanager.MangerHome;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sutudentmanager.R;
import com.example.sutudentmanager.SQLite.StudentSQlit;

public class DeleteStudent extends AppCompatActivity {

    private static final String dbFilefors = "student1.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        Button back = findViewById(R.id.button10);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentSQlit dbe = new StudentSQlit(getApplicationContext(),dbFilefors,null,1);
                SQLiteDatabase db = dbe.getWritableDatabase();

                EditText std_id = findViewById(R.id.student_id);
                String id = std_id.getText().toString();
                int result = db.delete("student","id=?",new String[]{id});
                Log.i("delete",String.valueOf(result));
                if (result == 1)
                    Toast.makeText(getApplicationContext(),"no such student",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
