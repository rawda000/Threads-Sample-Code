package com.rawda.threads_code_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button start;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.startThread_button);
        aSwitch = findViewById(R.id.switch_);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startThread();
    }

    private void startThread() {
        MyThread thread1 = new MyThread(10);
        thread1.start();
    }


    class MyThread extends Thread {
        private int seconds;

        public MyThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < seconds; i++) {
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
