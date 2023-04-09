package com.example.pract.view;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pract.R;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        startService(new Intent(this, FirstService.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
        stopService(new Intent(this, FirstService.class));
    }

}