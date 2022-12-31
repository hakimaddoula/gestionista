package com.example.exercices_sqlite_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView TextVie = findViewById(R.id.textView4);




        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");

        TextVie.setText(UserName);
    }
}