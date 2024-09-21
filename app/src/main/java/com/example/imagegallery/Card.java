package com.example.imagegallery;

public class Card {
    private String title, url;
    private int width, height;
    public Card(String title, String url, int width, int height) {
        this.title = title;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getImgUrl() {
        return url;
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    public String getTitle() {
        return title;
    }

}
