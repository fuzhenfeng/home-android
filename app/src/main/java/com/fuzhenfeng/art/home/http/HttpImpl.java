package com.fuzhenfeng.art.home.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpImpl implements Http {

    private final static String TAG = "HttpImpl";

    private static final String HTTP_JSON = "application/json; charset=utf-8";
    private static final String HTTP_FORM = "application/x-www-form-urlencoded; charset=utf-8";
    private static final String HTTP_XML = "application/xml";

    private static final int OK = 200;

    private OkHttpClient okHttpClient;

    public HttpImpl() {
        okHttpClient = new OkHttpClient();
    }

    @Override
    public String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.code() == OK) {
                return response.body().string();
            } else {
                Log.e(TAG, response.message());
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean put(String url, String json) {
        MediaType mediaType = MediaType.parse(HTTP_JSON);
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.code() == OK) {
                return true;
            } else {
                Log.e(TAG, response.message());
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean post(String url, String json) {
        MediaType mediaType = MediaType.parse(HTTP_JSON);
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.code() == OK) {
                return true;
            } else {
                Log.e(TAG, response.message());
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(String url) {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.code() == OK) {
                return true;
            } else {
                Log.e(TAG, response.message());
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return false;
    }
}
