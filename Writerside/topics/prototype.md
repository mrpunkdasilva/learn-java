# Prototype Pattern

## Visão Geral

O Prototype é um padrão criacional que permite copiar objetos existentes sem fazer seu código depender de suas classes.

```ascii
PROTOTYPE PATTERN
├── Prototype (Interface)
├── Concrete Prototype
└── Client
```

## Implementações

### 1. Prototype Básico

```java
public interface Prototype extends Cloneable {
    Prototype clone();
}

public class ConcretePrototype implements Prototype {
    private String field;
    
    public ConcretePrototype(String field) {
        this.field = field;
    }
    
    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.field);
    }
}
```

### 2. Deep Clone com Serialização

```java
public class DeepPrototype implements Serializable {
    private List<String> data;
    private ComplexObject object;
    
    public DeepPrototype deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (DeepPrototype) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

### 3. Prototype Registry

```java
public class PrototypeRegistry {
    private Map<String, Prototype> prototypes = new HashMap<>();
    
    public void addPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }
    
    public Prototype getPrototype(String key) {
        Prototype prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found");
        }
        return prototype.clone();
    }
}
```

## Casos de Uso

### 1. Sistema de Formas Geométricas

```java
public abstract class Shape implements Cloneable {
    private int x;
    private int y;
    private String color;
    
    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Circle extends Shape {
    private int radius;
    
    public Circle(int x, int y, String color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }
    
    @Override
    public Circle clone() {
        Circle clone = (Circle) super.clone();
        // Deep clone específico se necessário
        return clone;
    }
}
```

### 2. Sistema de Templates de Documentos

```java
public class DocumentTemplate implements Cloneable {
    private List<Section> sections = new ArrayList<>();
    private Map<String, String> metadata = new HashMap<>();
    
    public void addSection(Section section) {
        sections.add(section);
    }
    
    public void setMetadata(String key, String value) {
        metadata.put(key, value);
    }
    
    @Override
    public DocumentTemplate clone() {
        try {
            DocumentTemplate clone = (DocumentTemplate) super.clone();
            // Deep clone das coleções
            clone.sections = new ArrayList<>(this.sections);
            clone.metadata = new HashMap<>(this.metadata);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

## Melhores Práticas

1. **Clonagem Apropriada**
   - Decida entre shallow e deep clone
   - Implemente clone corretamente
   - Considere serialização para deep clone

2. **Gerenciamento de Estado**
   - Mantenha estado consistente
   - Clone recursos externos
   - Gerencie referências circulares

3. **Performance**
   - Use clone para objetos complexos
   - Cache prototypes frequentes
   - Otimize deep cloning

## Anti-Patterns

- Clone inconsistente
- Ignorar recursos externos
- Copiar referências mutáveis
- Não implementar clone corretamente

## Exercício Prático

Implemente um sistema de configurações usando Prototype:

```java
public class Configuration implements Cloneable {
    private Map<String, Object> settings;
    private List<String> activeModules;
    private SecurityConfig security;
    
    public Configuration() {
        this.settings = new HashMap<>();
        this.activeModules = new ArrayList<>();
        this.security = new SecurityConfig();
    }
    
    @Override
    public Configuration clone() {
        try {
            Configuration clone = (Configuration) super.clone();
            // Deep clone
            clone.settings = new HashMap<>(this.settings);
            clone.activeModules = new ArrayList<>(this.activeModules);
            clone.security = this.security.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static class SecurityConfig implements Cloneable {
        private String encryption;
        private List<String> allowedIPs;
        
        @Override
        public SecurityConfig clone() {
            try {
                SecurityConfig clone = (SecurityConfig) super.clone();
                clone.allowedIPs = new ArrayList<>(this.allowedIPs);
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

// Uso:
Configuration defaultConfig = new Configuration();
// Configurar default
Configuration customConfig = defaultConfig.clone();
// Personalizar
```

## Próximos Passos

- Explore clonagem profunda
- Estude serialização
- Combine com outros padrões
- Pratique com objetos complexos