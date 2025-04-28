package com.netrunner.documentgenerator.pdf;

import com.netrunner.documentgenerator.core.interfaces.Footer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PDFFooter implements Footer {
    private int pageNumber;
    private List<String> footnotes = new ArrayList<>();

    @Override
    public void setPageNumber(int number) {
        this.pageNumber = number;
    }

    @Override
    public void setFootnotes(List<String> footnotes) {
        this.footnotes = new ArrayList<>(footnotes);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append("% PDF Footer\n");
        sb.append(String.format("Page: %d\n", pageNumber));
        
        if (!footnotes.isEmpty()) {
            sb.append("Footnotes:\n");
            for (int i = 0; i < footnotes.size(); i++) {
                sb.append(String.format("[%d] %s\n", i + 1, footnotes.get(i)));
            }
        }
        
        return sb.toString();
    }
}