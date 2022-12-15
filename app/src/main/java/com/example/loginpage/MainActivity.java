package com.example.loginpage;

import static android.text.Html.fromHtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import db.DbHelper;


public class MainActivity extends AppCompatActivity {
    EditText Txusername;
    EditText Txpassword;
    DbHelper DbHelper;
    Button loginButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Txusername = (EditText) findViewById(R.id.Txusername);
        Txpassword = (EditText)findViewById(R.id.Txpassword);
        loginButton = (Button)findViewById(R.id.loginButton);
        DbHelper = new DbHelper(this);

        TextView daftarText = (TextView)findViewById(R.id.daftarText) ;
        daftarText.setText(fromHtml("<font>Belum Punya Akun?" +
                "</font><font color ='#FF000'><i>Segera Daftar Disini</i></font>"));
        daftarText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Txusername.getText().toString().trim();
                String password = Txpassword.getText().toString().trim();
                Boolean res= DbHelper.checkUser(username,password);
            if(res == true){
                Toast.makeText(MainActivity.this, "Login Succesful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }else{
                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }


}