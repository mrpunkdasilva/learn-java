# Annotation Processor

## Visão Geral
O Annotation Processor é um mecanismo poderoso do Java que permite processar anotações em tempo de compilação para gerar código, validar restrições e realizar outras tarefas de metaprogramação.

## Fundamentos

### O que é um Annotation Processor?
Um processador de anotações é uma ferramenta que analisa e processa anotações Java durante a compilação. Ele pode:
- Gerar novos arquivos fonte
- Validar uso de anotações
- Produzir mensagens de erro/aviso
- Modificar o processo de compilação

### Estrutura Básica
```java
@SupportedAnnotationTypes("com.example.annotations.*")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class CustomProcessor extends AbstractProcessor {
    @Override
    public boolean process(
        Set<? extends TypeElement> annotations,
        RoundEnvironment roundEnv
    ) {
        // Lógica de processamento
        return true;
    }
}
```

## Implementação

### Configuração do Projeto
1. Criar arquivo de serviço:
   `META-INF/services/javax.annotation.processing.Processor`
2. Adicionar dependências necessárias
3. Configurar plugin de compilação

### Processamento de Elementos
```java
@Override
public boolean process(
    Set<? extends TypeElement> annotations,
    RoundEnvironment roundEnv
) {
    for (TypeElement annotation : annotations) {
        Set<? extends Element> elements = 
            roundEnv.getElementsAnnotatedWith(annotation);
        
        for (Element element : elements) {
            // Processamento específico
            processElement(element);
        }
    }
    return true;
}
```

### Geração de Código
```java
private void generateCode(Element element) {
    JavaFileObject file = processingEnv.getFiler()
        .createSourceFile("GeneratedClass");
    
    try (PrintWriter out = new PrintWriter(file.openWriter())) {
        out.println("package com.example.generated;");
        out.println("public class GeneratedClass {");
        // Geração do código
        out.println("}");
    }
}
```

## Casos de Uso

### Builder Generator
```java
@Builder
public class User {
    private String name;
    private String email;
    private int age;
}

// Gera:
public class UserBuilder {
    private User user = new User();
    
    public UserBuilder name(String name) {
        user.setName(name);
        return this;
    }
    // ... outros métodos
}
```

### DTO Mapper
```java
@Mapper
public class UserEntity {
    private Long id;
    private String username;
    
    // Gera automaticamente:
    // - UserDTO
    // - UserMapper
}
```

### Validador de Anotações
```java
@ValidateAnnotation
public @interface Route {
    String path();
    String method();
}

// Valida em tempo de compilação:
// - Formato do path
// - Método HTTP válido
```

## Boas Práticas

### Desempenho
- Cache de elementos processados
- Minimizar operações I/O
- Processamento incremental

### Mensagens de Erro
```java
private void reportError(Element element, String message) {
    processingEnv.getMessager().printMessage(
        Diagnostic.Kind.ERROR,
        message,
        element
    );
}
```

### Testes
```java
@Test
public void testProcessor() {
    Compilation compilation = 
        javac()
            .withProcessors(new CustomProcessor())
            .compile(JavaFileObjects.forSourceString(
                "Test",
                "..."
            ));
    
    assertThat(compilation).succeeded();
    // Verificar saída gerada
}
```

## Ferramentas e Bibliotecas

### Utilitárias
- JavaPoet: Geração de código
- Auto Service: Registro de processadores
- Compile Testing: Testes de compilação

### Integração IDE
- Suporte a processamento incremental
- Debugging de processadores
- Visualização de código gerado

## Exemplos Avançados

### Gerador de API REST
```java
@RestController
@RequestMapping("/api")
public class UserController {
    // Gera:
    // - Documentation
    // - Client SDK
    // - Test Cases
}
```

### Gerador de Documentação
```java
@ApiDoc(
    description = "Gerencia usuários",
    version = "1.0"
)
public class UserService {
    // Gera:
    // - Markdown
    // - HTML
    // - OpenAPI spec
}
```

## Recursos Adicionais

### Links Úteis
- [Documentação Oracle](https://docs.oracle.com/javase/8/docs/api/javax/annotation/processing/Processor.html)
- [JavaPoet GitHub](https://github.com/square/javapoet)
- [Annotation Processing Tool](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/apt.html)

### Projetos de Exemplo
- [Lombok](https://github.com/projectlombok/lombok)
- [Dagger](https://github.com/google/dagger)
- [MapStruct](https://github.com/mapstruct/mapstruct)