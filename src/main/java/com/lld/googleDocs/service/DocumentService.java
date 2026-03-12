package com.lld.googleDocs.service;
import com.lld.googleDocs.model.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentService {

    private Map<Integer, Document> documents = new HashMap<>();

    public Document createDocument(int id, String title, User owner){

        Document doc = new Document(id, title, owner);
        documents.put(id, doc);
        return doc;
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}
