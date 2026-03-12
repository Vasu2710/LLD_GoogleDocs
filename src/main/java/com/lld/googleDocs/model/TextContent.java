package com.lld.googleDocs.model;

import org.w3c.dom.Text;

public class TextContent extends Content{

    private String text;

    public TextContent(int id, String text){
        super(id);
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("TEXT: " + text);

    }
}
