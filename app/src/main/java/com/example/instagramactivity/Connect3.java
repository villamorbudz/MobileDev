package com.example.instagramactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Connect3 extends AppCompatActivity {

    private Button[] btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);

        boolean player1Turn;

        boolean cells[][] = new boolean[5][5];

        btn = new Button[]{
                findViewById(R.id.cell00Btn),
                findViewById(R.id.cell01Btn),
                findViewById(R.id.cell02Btn),
                findViewById(R.id.cell03Btn),
                findViewById(R.id.cell04Btn),
        };


        for (Button button : btn) {
            button.setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        
    }

}