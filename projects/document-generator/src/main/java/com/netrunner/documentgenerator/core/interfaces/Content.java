package com.netrunner.documentgenerator.core.interfaces;

public interface Content {
    void addSection(String title, String text);
    void addImage(String path, String caption);
    String render();
}