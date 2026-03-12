package com.lld.googleDocs.model;

import com.lld.googleDocs.enums.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {

    private int id;
    private String title;
    private User owner;
    private List<Content> contents = new ArrayList<>();
    private Map<User, Permission> permissionMap = new HashMap<>();

    public Document(int id, String title, User owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        permissionMap.put(owner, Permission.EDIT);
    }

    public void addContent(User user, Content content){

        if(permissionMap.get(user) != Permission.EDIT){
            throw new RuntimeException("No edit permission!");
        }
        contents.add(content);
    }


    public void viewDocument(User user) {

        if(!permissionMap.containsKey(user)) {
            throw new RuntimeException("No access");
        }

        for(Content c : contents) {
            c.render();
        }
    }

    public void shareDocument(User user, Permission permission) {
        permissionMap.put(user, permission);
    }
}
