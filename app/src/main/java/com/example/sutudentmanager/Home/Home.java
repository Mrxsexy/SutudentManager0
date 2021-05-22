package com.example.sutudentmanager.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sutudentmanager.MangerHome.AddStudent;
import com.example.sutudentmanager.MangerHome.DeleteStudent;
import com.example.sutudentmanager.MangerHome.SearchInfo;
import com.example.sutudentmanager.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewAddListenser();
    }

//    设置监听事件
    class mulListener implements View.OnClickListener{

        public void onClick(View v){
            switch (v.getId()){
                case R.id.button2:
                    Intent intent1 = new Intent(getApplicationContext(), AddStudent.class);
                    startActivity(intent1);
                    break;
                case R.id.button3:
                    Intent intent2 = new Intent(getApplicationContext(), DeleteStudent.class);
                    startActivity(intent2);
                    break;
                case R.id.button4:
                    Intent intent3 = new Intent(getApplicationContext(),AddStudent.class);
                    startActivity(intent3);
                    break;
                case R.id.button5:
                    Intent intent4 = new Intent(getApplicationContext(), SearchInfo.class);
                    startActivity(intent4);
                    break;

            }
        }
    }

//    设置监听器
    private void viewAddListenser(){
        Button add = findViewById(R.id.button2);
        Button del = findViewById(R.id.button3);
        Button change = findViewById(R.id.button4);
        Button sear = findViewById(R.id.button5);
        add.setOnClickListener(new mulListener());
        del.setOnClickListener(new mulListener());
        change.setOnClickListener(new mulListener());
        sear.setOnClickListener(new mulListener());

    }
}
