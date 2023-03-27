package com.fuzhenfeng.art.home.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.fuzhenfeng.art.home.model.User;
import com.google.gson.Gson;

public class DataImpl implements Data {

    private Context context;

    private SharedPreferences sharedPreferences;

    public DataImpl(Context context) {
        this.context = context;
    }

    @Override
    public void set(User user) {
        sharedPreferences = context.getSharedPreferences(Table.USER.getTableName(), context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        edit.putString(Table.USER.getTableName(), json);
        edit.commit();
    }

    @Override
    public User get() {
        sharedPreferences = context.getSharedPreferences(Table.USER.getTableName(), context.MODE_PRIVATE);
        String json = sharedPreferences.getString(Table.USER.getTableName(), "");
        Gson gson = new Gson();
        return gson.fromJson(json, User.class);
    }
}
