package com.example.itubeapp.model;

public class Playlist {

    private int playlist_id;
    private String username;
    private String url;

    public Playlist(String username, String url) {
        this.username = username;
        this.url = url;

    }

    public Playlist() {

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
