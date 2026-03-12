package com.lld.googleDocs.model;

public class LinkContent extends Content {

    private String url;

    public LinkContent(int id, String url) {
        super(id);
        this.url = url;
    }

    public void render() {
        System.out.println("Link: " + url);
    }
}
