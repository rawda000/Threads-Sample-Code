package com.rawda.threads_code_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button startThread1;
    private Button startThread2;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startThread1 = findViewById(R.id.startThread1_button);
        startThread2 = findViewById(R.id.startThread2_button);

        aSwitch = findViewById(R.id.switch_);
        startThread1.setOnClickListener(this);
        startThread2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.startThread1_button) {
            startThread1();
        } else if (id == R.id.startThread2_button) {
            startThread2();
        }
    }

    private void startThread1() {
        MyThread thread = new MyThread(10);
        thread.start();
    }


    private void startThread2() {
        MyRunnableThread thread = new MyRunnableThread(10);
        new Thread(thread).start();
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

    class MyRunnableThread implements Runnable {
        private int seconds;

        public MyRunnableThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
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


