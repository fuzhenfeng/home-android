package com.fuzhenfeng.art.home.http;

public interface Http {
    String get(String url);
    boolean put(String url, String json);
    boolean post(String url, String json);
    boolean delete(String url);
}
