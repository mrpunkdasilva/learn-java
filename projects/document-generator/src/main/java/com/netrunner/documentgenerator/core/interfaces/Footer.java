package com.netrunner.documentgenerator.core.interfaces;

import java.util.List;

public interface Footer {
    void setPageNumber(int number);
    void setFootnotes(List<String> footnotes);
    String render();
}