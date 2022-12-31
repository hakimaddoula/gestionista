package com.example.exercices_sqlite_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText User , Pass ;
Button Sing_IN , Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User = findViewById(R.id.UserName1);
        Pass = findViewById(R.id.Password1);

        Sing_IN = findViewById(R.id.Sing1);
        Register=findViewById(R.id.Register1);


        Sing_IN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyHalper helper = new MyHalper(MainActivity.this);
                boolean b  = false ;
                ArrayList<String> list = helper.GetData();

                for (String a:list
                     ) {
                    String[] x = a.split(" / ");
                    String U = x[1];
                    String P = x[2];

                    if (User.getText().toString().equals(U) && Pass.getText().toString().equals(P)){
                        b = true;
                        break;
                    }

                }

                if (b){
                    Intent Int = new Intent(MainActivity.this,MainActivity3.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("UserName",User.getText().toString());

                    Int.putExtras(bundle);
                    startActivity(Int);
                }
                else
                    Toast.makeText(MainActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Int = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(Int);
               }
        });
    }
}