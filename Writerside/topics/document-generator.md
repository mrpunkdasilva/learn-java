# Document Generator Pattern

## Visão Geral

O Document Generator é um exemplo prático do Abstract Factory Pattern que demonstra a criação de diferentes tipos de documentos (PDF, HTML, Markdown) mantendo uma estrutura consistente.

```ascii
DOCUMENT GENERATOR
├── Document Factories
│   ├── PDFDocumentFactory
│   ├── HTMLDocumentFactory
│   └── MarkdownDocumentFactory
├── Document Components
│   ├── Header
│   ├── Content
│   └── Footer
└── Document Types
    ├── Report
    ├── Article
    └── Manual
```

## Implementação

### 1. Interfaces Base

```java
// Componentes do Documento
public interface Header {
    void setTitle(String title);
    void setMetadata(Map<String, String> metadata);
    String render();
}

public interface Content {
    void addSection(String title, String text);
    void addImage(String path, String caption);
    String render();
}

public interface Footer {
    void setPageNumber(int number);
    void setFootnotes(List<String> footnotes);
    String render();
}

// Fábrica Abstrata
public interface DocumentFactory {
    Header createHeader();
    Content createContent();
    Footer createFooter();
}
```

### 2. Implementação PDF

```java
public class PDFHeader implements Header {
    private String title;
    private Map<String, String> metadata;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String render() {
        return String.format("PDF Header: %s\nMetadata: %s", title, metadata);
    }
}

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
```

### 3. Gerador de Documento

```java
public class DocumentGenerator {
    private final DocumentFactory factory;
    private Header header;
    private Content content;
    private Footer footer;

    public DocumentGenerator(DocumentFactory factory) {
        this.factory = factory;
    }

    public void createDocument() {
        header = factory.createHeader();
        content = factory.createContent();
        footer = factory.createFooter();
    }

    public void setDocumentTitle(String title) {
        header.setTitle(title);
    }

    public void addSection(String title, String text) {
        content.addSection(title, text);
    }

    public void setPageNumber(int number) {
        footer.setPageNumber(number);
    }

    public String generateDocument() {
        StringBuilder document = new StringBuilder();
        document.append(header.render())
                .append("\n")
                .append(content.render())
                .append("\n")
                .append(footer.render());
        return document.toString();
    }
}
```

## Exemplo de Uso

```java
public class DocumentGeneratorDemo {
    public static void main(String[] args) {
        // Criar relatório em PDF
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        DocumentGenerator pdfGenerator = new DocumentGenerator(pdfFactory);
        
        pdfGenerator.createDocument();
        pdfGenerator.setDocumentTitle("Relatório Financeiro");
        pdfGenerator.addSection("Resumo", "Análise financeira do Q3 2023");
        pdfGenerator.setPageNumber(1);
        
        String pdfDocument = pdfGenerator.generateDocument();
        System.out.println(pdfDocument);

        // Criar artigo em HTML
        DocumentFactory htmlFactory = new HTMLDocumentFactory();
        DocumentGenerator htmlGenerator = new DocumentGenerator(htmlFactory);
        
        htmlGenerator.createDocument();
        htmlGenerator.setDocumentTitle("Artigo Técnico");
        htmlGenerator.addSection("Introdução", "Conceitos de Design Patterns");
        htmlGenerator.setPageNumber(1);
        
        String htmlDocument = htmlGenerator.generateDocument();
        System.out.println(htmlDocument);
    }
}
```

## Extensões Possíveis

1. **Suporte a Temas**
```java
public interface Theme {
    String getHeaderStyle();
    String getContentStyle();
    String getFooterStyle();
}

public class DocumentFactory {
    private Theme theme;
    
    public DocumentFactory(Theme theme) {
        this.theme = theme;
    }
    
    // Métodos de fábrica usando o tema
}
```

2. **Exportação Multi-formato**
```java
public interface DocumentExporter {
    void export(String content, String path);
}

public class PDFExporter implements DocumentExporter {
    @Override
    public void export(String content, String path) {
        // Lógica de exportação para PDF
    }
}
```

## Considerações de Design

1. **Separação de Responsabilidades**
   - Cada fábrica cuida apenas da criação
   - Lógica de renderização nos componentes
   - Exportação separada da geração

2. **Extensibilidade**
   - Fácil adicionar novos formatos
   - Suporte a diferentes temas
   - Componentes reutilizáveis

3. **Manutenibilidade**
   - Estrutura consistente
   - Código organizado
   - Fácil de testar

## Exercícios

1. Implemente o `MarkdownDocumentFactory` com seus componentes
2. Adicione suporte para diferentes temas
3. Crie um sistema de templates
4. Implemente exportação para diferentes formatos

## Próximos Passos

- Explore combinações com Builder Pattern
- Adicione validação de documentos
- Implemente cache de componentes
- Crie pipeline de processamento
- Adicione suporte a internacionalização