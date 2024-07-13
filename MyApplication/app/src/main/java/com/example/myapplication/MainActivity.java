package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_second = findViewById(R.id.button_second);
        TextView main_text = findViewById(R.id.main_text);

        button_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showInfo(main_text.getText().toString(), button_second);
                showInfoAlert("Do you want to exit of the app?");
            }
        });
    }

    public void btnClick(View v){
        showInfo(((Button) v).getText().toString(), (Button) v);
    }

    private void showInfoAlert(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfo(String text, Button btn){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        btn.setText("Click");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
    }

    public void startSecondActivity(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}