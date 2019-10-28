package com.rawda.threads_code_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.startThread_button);
        start.setOnClickListener(this);
    }

    private void startThread(){
        MyThread1 thread1 = new MyThread1(10);
        thread1.start();
    }

    @Override
    public void onClick(View v) {
        startThread();
    }

    class MyThread1 extends Thread{
        private int seconds;

        public MyThread1(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            super.run();
            for  (int i = 0; i < seconds; i++){
                try {
                    Thread.sleep(1000);
                    Log.i(TAG, "startThread: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
