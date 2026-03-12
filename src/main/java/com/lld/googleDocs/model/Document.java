package com.lld.googleDocs.model;

import com.lld.googleDocs.enums.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {

    private Integer id;
    private String title;

    private User owner;

    private StringBuilder content = new StringBuilder();

    private Map<Integer, Permission> permissions = new HashMap<>();

    private Map<Integer, UserSession> activeSessions = new HashMap<>();

    public Document(Integer id, String title, User owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;

        permissions.put(owner.getId(), Permission.EDIT);
    }

    public User getOwner() {
        return owner;
    }

    public void shareDocument(User ownerUser, User targetUser, Permission permission) {

        if(!ownerUser.getId().equals(owner.getId())) {
            throw new RuntimeException("Only owner can share document");
        }

        permissions.put(targetUser.getId(), permission);
    }

    public void joinSession(User user) {

        if(!permissions.containsKey(user.getId())) {
            throw new RuntimeException("User has no access");
        }

        activeSessions.put(user.getId(), new UserSession(user));
    }

    public void moveCursor(User user, int position) {

        UserSession session = activeSessions.get(user.getId());
        session.getCursor().move(position);

        broadcast(user.getId() + " moved cursor to " + position);
    }

    public void applyEdit(User user, EditOperation operation) {

        Permission permission = permissions.get(user.getId());

        if(permission != Permission.EDIT) {
            throw new RuntimeException("No edit permission");
        }

        if(operation.getType() == EditOperation.Type.INSERT) {

            content.insert(operation.getPosition(), operation.getText());
        }
        else {

            int start = operation.getPosition();
            int end = start + operation.getText().length();
            content.delete(start, end);
        }

        broadcast("Document updated: " + content.toString());
    }

    private void broadcast(String message) {

        for(UserSession session : activeSessions.values()) {
            session.notifyUpdate(message);
        }
    }

    public String getContent() {
        return content.toString();
    }
}