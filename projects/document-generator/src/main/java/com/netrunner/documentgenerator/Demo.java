package com.netrunner.documentgenerator;

import com.netrunner.documentgenerator.core.DocumentGenerator;
import com.netrunner.documentgenerator.core.interfaces.DocumentFactory;
import com.netrunner.documentgenerator.pdf.PDFDocumentFactory;
import com.netrunner.documentgenerator.html.HTMLDocumentFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        // PDF Document Example
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        DocumentGenerator pdfGenerator = new DocumentGenerator(pdfFactory);
        
        pdfGenerator.createDocument();
        pdfGenerator.setDocumentTitle("Technical Report");
        
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Author", "John Doe");
        metadata.put("Date", "2023-12-01");
        
        pdfGenerator.addSection("Introduction", "This is the introduction section.");
        pdfGenerator.addImage("diagram.png", "System Architecture Diagram");
        pdfGenerator.setPageNumber(1);
        
        String pdfDocument = pdfGenerator.generateDocument();
        System.out.println("PDF Document:");
        System.out.println(pdfDocument);
        
        // HTML Document Example
        DocumentFactory htmlFactory = new HTMLDocumentFactory();
        DocumentGenerator htmlGenerator = new DocumentGenerator(htmlFactory);
        
        htmlGenerator.createDocument();
        htmlGenerator.setDocumentTitle("Web Article");
        htmlGenerator.addSection("Getting Started", "Learn about document generation.");
        htmlGenerator.addImage("preview.jpg", "Preview Image");
        htmlGenerator.setPageNumber(1);
        
        String htmlDocument = htmlGenerator.generateDocument();
        System.out.println("\nHTML Document:");
        System.out.println(htmlDocument);
    }
}