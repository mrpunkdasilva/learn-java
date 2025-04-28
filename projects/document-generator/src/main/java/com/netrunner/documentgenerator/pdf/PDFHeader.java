package com.netrunner.documentgenerator.pdf;

import com.netrunner.documentgenerator.core.interfaces.Header;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class PDFHeader implements Header {
    private String title;
    private Map<String, String> metadata = new HashMap<>();

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = new HashMap<>(metadata);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append("%PDF-1.7\n");
        sb.append("% PDF Header\n");
        sb.append(String.format("Title: %s\n", title));
        metadata.forEach((key, value) -> 
            sb.append(String.format("%s: %s\n", key, value)));
        return sb.toString();
    }
}