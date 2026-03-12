package com.lld.googleDocs.model;

public class Cursor {

    private int position;

    public Cursor(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(int newPosition) {
        this.position = newPosition;
    }
}
