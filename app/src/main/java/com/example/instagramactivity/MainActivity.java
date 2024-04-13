package com.example.instagramactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.layoutActivityBtn).setOnClickListener(view -> {
            Intent openActivity = new Intent(MainActivity.this, LayoutExercise.class);
            startActivity(openActivity);
        });

        findViewById(R.id.buttonsActivityBtn).setOnClickListener(view -> {
            Intent openActivity = new Intent(MainActivity.this, ButtonActivity.class);
            startActivity(openActivity);
        });

        findViewById(R.id.calculatorActivityBtn).setOnClickListener(view -> {
            Intent openActivity = new Intent(MainActivity.this, Calculator.class);
            startActivity(openActivity);
        });

        findViewById(R.id.connect3Btn).setOnClickListener(view -> {
            Intent openActivity = new Intent(MainActivity.this, Connect3.class);
            startActivity(openActivity);
        });
    }
}