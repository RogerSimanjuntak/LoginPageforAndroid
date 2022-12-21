package com.example.loginpage;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;
import db.DbHelper;
import model.user;

public class UserActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView email = findViewById(R.id.emailprofile);
        Bundle extras = getIntent().getExtras();
        DbHelper db = new DbHelper(this);
        String emailText = extras.getString("email");
        ArrayList<user> user = db.searchUser(emailText);
        email.setText(user.get(0).getEmail());
}
}