package com.fuzhenfeng.art.home.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fuzhenfeng.art.home.MainActivity;
import com.fuzhenfeng.art.home.R;
import com.fuzhenfeng.art.home.guide.GuideActivity;
import com.fuzhenfeng.art.home.http.Http;
import com.fuzhenfeng.art.home.http.HttpImpl;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextTextPassword)).getText().toString();
        if ("".equals(username) && "".equals(password)) {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
//        Http http = new HttpImpl();
//        LoginInfo loginInfo = new LoginInfo(username, password);
//        boolean result = http.post("", new Gson().toJson(loginInfo));
//        Toast.makeText(this, "连接" + (result?"成功":"失败"), Toast.LENGTH_SHORT).show();
//        if (result) {
            Intent home =  new Intent(LoginActivity.this, GuideActivity.class);
            startActivity(home);
//        }
    }
}