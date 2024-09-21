package com.example.imagegallery;

import android.util.Log;

public class ImgResponse {
    private String download_url, author;
    private int height, width;
    public String getImgUrl() { return download_url; }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String getTitle() { return author; }

}
