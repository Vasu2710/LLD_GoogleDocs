package com.lld.googleDocs;

import com.lld.googleDocs.enums.Permission;
import com.lld.googleDocs.model.*;
import com.lld.googleDocs.service.DocumentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.Doc;


@SpringBootApplication
public class GoogleDocsApplication {

	public static void main(String[] args) {

		User userA = new User(1, "userA");
		User userB = new User(2, "userB");

		DocumentService documentService = new DocumentService();
		Document document = documentService.createDocument(1, "Doc1", userA);

		document.addContent(userA, new TextContent(1, "Hello World!!"));
		document.addContent(userA, new ImageContent(2, "image.png"));
		document.addContent(userA, new LinkContent(3, "https://google.com"));

		document.shareDocument(userB, Permission.VIEW);

		document.viewDocument(userB);
	}

}
