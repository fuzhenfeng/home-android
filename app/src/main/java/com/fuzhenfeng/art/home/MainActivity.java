package com.fuzhenfeng.art.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fuzhenfeng.art.home.data.Data;
import com.fuzhenfeng.art.home.data.DataImpl;
import com.fuzhenfeng.art.home.guide.GuideActivity;
import com.fuzhenfeng.art.home.login.LoginActivity;
import com.fuzhenfeng.art.home.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Data data = new DataImpl(this);
        User user = data.get();
        if(user == null) {
            Intent home =  new Intent(MainActivity.this, LoginActivity.class);
            startActivity(home);
        } else {
            Intent apply =  new Intent(MainActivity.this, GuideActivity.class);
            startActivity(apply);
        }
        finish();
    }
}