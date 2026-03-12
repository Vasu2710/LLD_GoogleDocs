package com.lld.googleDocs.model;

public class User {

    private Integer id;
    private String name;


    public User(int id, String name){
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
