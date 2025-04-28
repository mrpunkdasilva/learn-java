package com.netrunner.documentgenerator.pdf;

import com.netrunner.documentgenerator.core.interfaces.Content;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PDFContent implements Content {
    private final List<Section> sections = new ArrayList<>();
    private final List<Image> images = new ArrayList<>();

    @Override
    public void addSection(String title, String text) {
        sections.add(new Section(title, text));
    }

    @Override
    public void addImage(String path, String caption) {
        images.add(new Image(path, caption));
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append("% PDF Content\n");
        
        sections.forEach(section -> {
            sb.append(String.format("Section: %s\n", section.getTitle()));
            sb.append(String.format("Content: %s\n", section.getText()));
            sb.append("\n");
        });

        images.forEach(image -> {
            sb.append(String.format("Image: %s\n", image.getPath()));
            sb.append(String.format("Caption: %s\n", image.getCaption()));
            sb.append("\n");
        });

        return sb.toString();
    }

    @Getter
    private static class Section {
        private final String title;
        private final String text;

        public Section(String title, String text) {
            this.title = title;
            this.text = text;
        }
    }

    @Getter
    private static class Image {
        private final String path;
        private final String caption;

        public Image(String path, String caption) {
            this.path = path;
            this.caption = caption;
        }
    }
}