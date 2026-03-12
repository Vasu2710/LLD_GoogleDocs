package com.lld.googleDocs.model;

public class UserSession {

    private User user;
    private Cursor cursor;

    public UserSession(User user) {
        this.user = user;
        this.cursor = new Cursor(0);
    }

    public User getUser() {
        return user;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void notifyUpdate(String message) {
        System.out.println(user.getId() + " received update: " + message);
    }
}
