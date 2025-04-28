package com.netrunner.documentgenerator.core.interfaces;

import java.util.Map;

public interface Header {
    void setTitle(String title);
    void setMetadata(Map<String, String> metadata);
    String render();
}