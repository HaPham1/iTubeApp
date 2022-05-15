package com.example.itubeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class YoutubeConfig {
    public YoutubeConfig() {

    }

    private static final String API_KEY = "AIzaSyDUHw9q7mt1p08TihayRZGbtyAngxlFa5o";

    public static String getApiKey() {
        return API_KEY;
    }
}