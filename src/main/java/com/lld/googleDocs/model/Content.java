package com.lld.googleDocs.model;

public abstract class Content {

    private int id;

    public Content(int id) {
        this.id = id;
    }

    public abstract void render();
}
