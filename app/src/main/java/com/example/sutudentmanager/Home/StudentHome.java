package com.example.sutudentmanager.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sutudentmanager.MangerHome.SearchInfo;
import com.example.sutudentmanager.R;

public class StudentHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();

        Button btn = findViewById(R.id.button7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchInfo.class);
                startActivity(intent);

            }
        });
        Button btn1 = findViewById(R.id.button6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchInfo.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }
}
