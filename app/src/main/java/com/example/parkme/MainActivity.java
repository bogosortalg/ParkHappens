package com.example.parkme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ImageView background = (ImageView) findViewById(R.id.imageView2);
        background.setImageResource(R.drawable.bg_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageButton bt_forward = findViewById(R.id.bt_wcscreen);
        bt_forward.setOnClickListener(view -> {
            Log.d(TAG, "Button click handled");
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });
    }
}