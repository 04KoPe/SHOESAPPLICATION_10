package com.example.shoesapplication.AccountPackage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class User {
    private String userName;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User signUp(Context context, User user) {
        if(user == null) return null;
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference("users").push().setValue(user);

        SharedPreferences sharedPreferences = context.getSharedPreferences("auth_info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", new Gson().toJson(user));
        editor.apply();
        return user;
    }

    public static User getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("auth_info",Context.MODE_PRIVATE);
        String userJson = sharedPreferences.getString("user", null);
        if(userJson == null) return null;
        return new Gson().fromJson(userJson, User.class);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
