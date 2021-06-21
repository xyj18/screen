package com.example.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btn_skip;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // 隐藏状态栏

        setContentView(R.layout.activity_main);


        btn_skip = findViewById(R.id.button);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main.class);
                startActivity(intent);
                MainActivity.this.finish();
                timer.cancel();

            }
        });

        init();
    }

    //广告倒计时跳转按钮开始
    private void init(){
        timer = new CountDownTimer(5*1000,1000) {
            @Override
            public void onTick(long l) {
                btn_skip.setText("跳过" + "(" + (l/1000+1) + "秒)");

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this,Main.class);
                startActivity(intent);
                MainActivity.this.finish();


            }
        }.start();
    }

    //广告倒计时调转按钮结束









}
