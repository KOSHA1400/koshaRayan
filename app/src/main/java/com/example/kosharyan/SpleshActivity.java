package com.example.kosharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class SpleshActivity extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splesh);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                Intent intent=new Intent(SpleshActivity.this,MainActivity.class);
                startActivity(intent);
                timer.cancel();
                finish();
            }
        },2000,2000);
    }
}