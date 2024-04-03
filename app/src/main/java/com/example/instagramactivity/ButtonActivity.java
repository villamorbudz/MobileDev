package com.example.instagramactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button closeBtn = findViewById(R.id.closeBtn);
        Button toastBtn = findViewById(R.id.toastBtn);
        Button changeBGBtn = findViewById(R.id.changeBGBtn);
        Button changeButtonBGBtn = findViewById(R.id.changeButtonBGBtn);
        Button disappearBtn = findViewById(R.id.disappearBtn);

        closeBtn.setOnClickListener(view -> {
            finish();
        });

        toastBtn.setOnClickListener(view -> {
            Toast toast = Toast.makeText(getApplicationContext(), "This is a toast!", Toast.LENGTH_SHORT);
            toast.show();
        });

        changeBGBtn.setOnClickListener(view -> {
            ConstraintLayout background = findViewById(R.id.mainLayout);
            background.setBackgroundColor(0xFF000000);
        });

        changeButtonBGBtn.setOnClickListener(view -> {
            changeButtonBGBtn.setBackgroundColor(0xFF5d5555);
        });

        disappearBtn.setOnClickListener(view -> {
            disappearBtn.setVisibility(View.INVISIBLE);
        });

    }
}