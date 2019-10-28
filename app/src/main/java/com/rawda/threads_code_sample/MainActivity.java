package com.rawda.threads_code_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startThread();
    }
    private void startThread(){
        for  (int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
                Log.i(TAG, "startThread: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
