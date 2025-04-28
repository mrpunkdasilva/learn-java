package com.netrunner.documentgenerator.core.interfaces;

public interface DocumentFactory {
    Header createHeader();
    Content createContent();
    Footer createFooter();
}