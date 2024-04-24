package com.example.layoutactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ConstraintLayout background = findViewById(R.id.menuActivityBackground);
        switch (item.getItemId()) {
            case R.id.mItemChange:
                Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mItemReset:
                Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
                reset();
                break;
            case R.id.mItemExit:
                finish();
                break;
            case R.id.mItemChangeText:
                btnChanger.setText("????????");
                break;
            case R.id.mItemChangeBG:
                background.setBackgroundColor(0xFF000000);
                break;
            case R.id.mItemChangeButtonColor:
                btnChanger.setBackgroundColor(0xFF5d5555);
                break;
            case R.id.mItemChangeTextColor:
                btnChanger.setTextColor(0xFFFFFF00);
                break;
            case R.id.mItemChangeOpacity:
                btnChanger.getBackground().setAlpha(75);
                break;
        }
        return true;
    }

    public void reset() {
        ConstraintLayout background = findViewById(R.id.menuActivityBackground);
        btnChanger.setText("Button");
        background.setBackgroundColor(0xFFFFFFFF);
        btnChanger.setBackgroundColor(0xFF0000FF);
        btnChanger.setTextColor(0xFFFFFFFF);
        btnChanger.getBackground().setAlpha(255);
    }

}