package com.example.intentfilterpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        view=findViewById(R.id.textview1);
        Intent intent=getIntent();
        String data=intent.getStringExtra("name");
        int age=intent.getIntExtra("age",4);
        view.setText(data+"Age"+age);
    }
}