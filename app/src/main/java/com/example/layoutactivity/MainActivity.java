package com.example.layoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

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

        findViewById(R.id.connectMatch3Btn).setOnClickListener(view -> {
            Intent openActivity = new Intent(MainActivity.this, Connect3.class);
            startActivity(openActivity);
        });

        findViewById(R.id.passingIntentsActivityBtn).setOnClickListener(view -> {
            Intent openActivity = new Intent(MainActivity.this, PassingIntentsExercise.class);
            startActivity(openActivity);
        });

        findViewById(R.id.menusActivityBtn).setOnClickListener(view -> {
            Intent openActivity = new Intent(MainActivity.this, MenuExercise.class);
            startActivity(openActivity);
        });
    }
}