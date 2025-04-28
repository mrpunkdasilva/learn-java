public interface Prototype extends Cloneable {
    Prototype clone();
}

public class Document implements Prototype {
    private String content;
    private String metadata;
    
    public Document(String content, String metadata) {
        this.content = content;
        this.metadata = metadata;
    }
    
    @Override
    public Document clone() {
        return new Document(this.content, this.metadata);
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}