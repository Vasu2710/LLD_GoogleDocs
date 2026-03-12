package com.lld.googleDocs.model;

public class EditOperation {

    public enum Type {
        INSERT,
        DELETE
    }

    private Type type;
    private String text;
    private int position;

    public EditOperation(Type type, String text, int position) {
        this.type = type;
        this.text = text;
        this.position = position;
    }

    public Type getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public int getPosition() {
        return position;
    }
}