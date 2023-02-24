package com.example.parkme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ParkMe";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast t1 = Toast.makeText(getApplicationContext(), "App created", Toast.LENGTH_SHORT);
        t1.show();
        Log.i(TAG, "App was created successfully");
        setContentView(R.layout.activity_main);
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast t2 = Toast.makeText(getApplicationContext(),
                "App closed", Toast.LENGTH_SHORT);
        t2.show();

        Log.e(TAG, "App has been closed successfully");
    }

    protected void onRestart() {
        super.onRestart();
        Toast t3 = Toast.makeText(getApplicationContext(),
                "App restarted", Toast.LENGTH_SHORT);
        t3.show();
        Log.v(TAG, "App was successfully restarted");
    }

    protected void onPause() {
        super.onPause();
        Toast t4 = Toast.makeText(getApplicationContext(),
                "App paused", Toast.LENGTH_SHORT);
        t4.show();
        Log.w(TAG, "App was successfully paused");
    }

    protected void onStop() {
        super.onStop();
        Toast t5 = Toast.makeText(getApplicationContext(),
                "App stopped", Toast.LENGTH_SHORT);
        t5.show();
        Log.d(TAG, "App has been successfully stopped");
    }

    protected void onStart() {
        super.onStart();
        Toast t6 = Toast.makeText(getApplicationContext(),
                "App started", Toast.LENGTH_SHORT);
        t6.show();
        Log.i(TAG, "App has been successfully started");
    }

    protected void onResume() {
        super.onResume();
        Toast t7 = Toast.makeText(getApplicationContext(),
                "Application relaunched", Toast.LENGTH_SHORT);
        t7.show();
        Log.v(TAG, "App has been successfully resumed");
    }
}