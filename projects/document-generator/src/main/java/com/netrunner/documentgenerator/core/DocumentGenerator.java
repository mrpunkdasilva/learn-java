package com.netrunner.documentgenerator.core;

import com.netrunner.documentgenerator.core.interfaces.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DocumentGenerator {
    private final DocumentFactory factory;
    private Header header;
    private Content content;
    private Footer footer;

    public void createDocument() {
        header = factory.createHeader();
        content = factory.createContent();
        footer = factory.createFooter();
    }

    public void setDocumentTitle(String title) {
        header.setTitle(title);
    }

    public void addSection(String title, String text) {
        content.addSection(title, text);
    }

    public void addImage(String path, String caption) {
        content.addImage(path, caption);
    }

    public void setPageNumber(int number) {
        footer.setPageNumber(number);
    }

    public String generateDocument() {
        StringBuilder document = new StringBuilder();
        document.append(header.render())
                .append("\n")
                .append(content.render())
                .append("\n")
                .append(footer.render());
        return document.toString();
    }
}