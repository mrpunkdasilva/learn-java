package com.netrunner.documentgenerator.html;

import com.netrunner.documentgenerator.core.interfaces.*;

public class HTMLDocumentFactory implements DocumentFactory {
    @Override
    public Header createHeader() {
        return new HTMLHeader();
    }

    @Override
    public Content createContent() {
        return new HTMLContent();
    }

    @Override
    public Footer createFooter() {
        return new HTMLFooter();
    }
}