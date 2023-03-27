package com.fuzhenfeng.art.home.data;

public enum Table {

    USER("user");

    private String tableName;

    Table(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
