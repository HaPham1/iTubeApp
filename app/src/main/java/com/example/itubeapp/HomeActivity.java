package com.example.itubeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itubeapp.data.DatabaseHelper2;
import com.example.itubeapp.model.Playlist;

public class HomeActivity extends AppCompatActivity {

    EditText urlEdit;
    Button playBtn, addBtn, listBtn;
    DatabaseHelper2 db2;
    String username, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        urlEdit = findViewById(R.id.urlEdit);
        playBtn = findViewById(R.id.playBtn);
        addBtn = findViewById(R.id.addBtn);
        listBtn = findViewById(R.id.listBtn);

        Intent intent =getIntent();
        username = intent.getStringExtra("username");

        db2 = new DatabaseHelper2(this);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(HomeActivity.this, PlayActivity.class);
                playIntent.putExtra("video", urlEdit.getText().toString());
                startActivity(playIntent);
            }
        });




        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url =urlEdit.getText().toString();
                long result =db2.insertPlaylist(new Playlist(username, url));
                if (result > 0){
                    Toast.makeText(HomeActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(HomeActivity.this, "Registration error!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, ListActivity.class);
                intent1.putExtra("username", username);
                startActivity(intent1);
            }
        });


    }
}