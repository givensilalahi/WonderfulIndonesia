package com.example.gjsilalahi.recyclerviewaja;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class SplashScreenAct extends AppCompatActivity {

    private static int splashInterval = 5000;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.loading);

        new Thread(new Runnable(){
            public void run() {
                while (progressStatus < 100) {
                    progressStatus +=1;

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }


            }
        }).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
                startActivity(i);
                finish();
            }

        }, splashInterval);

    }

}
