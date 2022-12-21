package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email");
        Intent intent = new Intent(this,UserActivity.class);
        intent.putExtra("email",email);
        startActivity(intent);
        return true;
}
}