package com.lld.googleDocs.model;

public class ImageContent extends Content {

    private String imageUrl;

    public ImageContent(int id, String imageUrl) {
        super(id);
        this.imageUrl = imageUrl;
    }

    public void render() {
        System.out.println("Image: " + imageUrl);
    }
}
