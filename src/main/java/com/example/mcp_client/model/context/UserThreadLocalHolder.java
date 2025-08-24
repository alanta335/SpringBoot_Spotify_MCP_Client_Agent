package com.example.mcp_client.model.context;

public class UserThreadLocalHolder {
    private static final ThreadLocal<UserDataModel> userHeaderData = new ThreadLocal<>();

    public static void setUserHeader(UserDataModel user) {
        userHeaderData.set(user);
    }

    public static UserDataModel getUserHeader() {
        return userHeaderData.get();
    }

    public static void clear() {
        userHeaderData.remove();
    }
}
