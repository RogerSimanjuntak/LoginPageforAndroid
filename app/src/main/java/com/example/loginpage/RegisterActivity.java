package com.example.loginpage;

import static android.text.Html.fromHtml;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import db.DbHelper;

public class RegisterActivity extends AppCompatActivity {

    EditText TxUsername, TxPassword, TxConPassword,TxEmail;
    Button BtnRegister;
    DbHelper DbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DbHelper = new DbHelper(this);

        TxUsername = (EditText) findViewById(R.id.TxRegusername);
        TxPassword = (EditText) findViewById(R.id.TxRegpassword);
        TxConPassword = (EditText) findViewById(R.id.Txsecondpasword);
        TxEmail = (EditText) findViewById(R.id.Txemail);
        BtnRegister = (Button) findViewById(R.id.RegisterButton);


        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = TxUsername.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();
                String conPassword = TxConPassword.getText().toString().trim();
                String email = TxEmail.getText().toString().trim();

                ContentValues values = new ContentValues();


                if (!password.equals(conPassword)) {
                    Toast.makeText(RegisterActivity.this, "Password not match", Toast.LENGTH_SHORT).show();
                } else if (password.equals("") || username.equals("") || email.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Username or Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    values.put(DbHelper.row_username, username);
                    values.put(DbHelper.row_password, password);
                    DbHelper.insertData(values);

                    Toast.makeText(RegisterActivity.this, "Register successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }}