package com.example.itubeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.itubeapp.data.DatabaseHelper2;
import com.example.itubeapp.model.Playlist;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView playListView;
    ArrayList<String> urlArrayList;
    ArrayAdapter<String> adapter;
    DatabaseHelper2 db2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        playListView = findViewById(R.id.playListView);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        urlArrayList = new ArrayList<>();
        db2 = new DatabaseHelper2(this);

        List<Playlist> playlistList = db2.fetchSelectedLists(username);
        for (Playlist playlist : playlistList) {
            urlArrayList.add("https://www.youtube.com/watch?v=" + playlist.getUrl());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, urlArrayList);
        playListView.setAdapter(adapter);
    }
}