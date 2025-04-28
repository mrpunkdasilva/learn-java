package com.netrunner.documentgenerator.pdf;

import com.netrunner.documentgenerator.core.interfaces.*;

public class PDFDocumentFactory implements DocumentFactory {
    @Override
    public Header createHeader() {
        return new PDFHeader();
    }

    @Override
    public Content createContent() {
        return new PDFContent();
    }

    @Override
    public Footer createFooter() {
        return new PDFFooter();
    }
}