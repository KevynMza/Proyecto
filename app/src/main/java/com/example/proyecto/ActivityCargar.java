package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ActivityCargar extends AppCompatActivity {
    int progressInt = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cargar);

            ProgressBar ProgressBar = findViewById(R.id.pb);
            TextView textView = findViewById(R.id.tv);


            Activity activity = ActivityCargar.this;


            ProgressBar.setProgress(progressInt);
            ProgressBar.setMax(100);

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    progressInt = progressInt+5;
                    ProgressBar.setProgress(progressInt);

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(progressInt)+"%");


                        }
                    });

                    if (ProgressBar.getProgress()>=100){

                        timer.cancel();


                        Intent intent = new Intent(ActivityCargar.this,MainActivity.class);
                        activity.startActivity(intent);
                        finish();




                    }





                }
            },1000,200);




        }
    }



