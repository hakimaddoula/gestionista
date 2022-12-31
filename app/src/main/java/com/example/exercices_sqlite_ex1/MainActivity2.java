package com.example.exercices_sqlite_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
EditText FN , UN , PS , C_PS ;
Button Reg , Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Reg = findViewById(R.id.register2);
        Login=findViewById(R.id.login);

        FN=findViewById(R.id.FullName2);
        UN = findViewById(R.id.UserName2);
        PS = findViewById(R.id.Password2);
        C_PS = findViewById(R.id.confirm);


       Reg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               MyHalper helper = new MyHalper(MainActivity2.this);

               if (PS.getText().toString().equals(C_PS.getText().toString())){

                   Boolean bb =  helper.AddUser(FN.getText().toString(), UN.getText().toString(), PS.getText().toString());
                  if (bb) {
                      Toast.makeText(MainActivity2.this, "User ADD", Toast.LENGTH_SHORT).show();
                      Intent Int = new Intent(MainActivity2.this,MainActivity.class);
                      startActivity(Int);

                  }
                  else Toast.makeText(MainActivity2.this, "User Not ADD", Toast.LENGTH_SHORT).show();

               }
               else {
                   Toast.makeText(MainActivity2.this, "Confirm Password", Toast.LENGTH_SHORT).show();
                    PS.setText("");
                    C_PS.setText("");


               }           }
       });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Int = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(Int);

            }
        });
    }
}