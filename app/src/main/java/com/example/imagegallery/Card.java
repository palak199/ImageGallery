package com.example.imagegallery;

public class Card {
    private String title, url;
    public Card(String url, String title) {
        this.title = title;
        this.url = url;
    }

    public String getImgUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

}
