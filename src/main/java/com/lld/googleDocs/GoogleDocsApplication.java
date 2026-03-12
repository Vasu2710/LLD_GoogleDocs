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

			User owner = new User(1, "Alice");
			User editor = new User(2, "Bob");
			User viewer = new User(3, "Charlie");

			Document doc = new Document(1, "Design Doc", owner);

			doc.shareDocument(owner, editor, Permission.EDIT);
			doc.shareDocument(owner, viewer, Permission.VIEW);

			doc.joinSession(owner);
			doc.joinSession(editor);
			doc.joinSession(viewer);

			doc.applyEdit(owner,
					new EditOperation(EditOperation.Type.INSERT, "Hello ", 0));

			doc.moveCursor(editor, 6);

			doc.applyEdit(editor,
					new EditOperation(EditOperation.Type.INSERT, "World", 6));
		}
}
