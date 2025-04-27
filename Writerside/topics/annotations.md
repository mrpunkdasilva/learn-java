# Anotações em Java

## Fundamentos

### O que são Anotações?
Anotações são metadados que podem ser adicionados ao código Java para fornecer informações adicionais sobre o programa.

## Tipos de Anotações

### Built-in Annotations
```java
@Override
@Deprecated
@SuppressWarnings
@FunctionalInterface
@SafeVarargs
```

### Meta-Annotations
```java
@Retention
@Target
@Documented
@Inherited
@Repeatable
```

## Criando Anotações

### Sintaxe Básica
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    String value() default "";
    boolean enabled() default true;
}
```

### Elementos de Anotação
```java
public @interface Configuration {
    String name();              // Elemento obrigatório
    int port() default 8080;    // Elemento com valor default
    String[] protocols();       // Array
}
```

## Criando Annotations Personalizadas

### Anatomia de uma Annotation
```java
@Retention(RetentionPolicy.RUNTIME)           // Quando a annotation está disponível
@Target({ElementType.METHOD, ElementType.TYPE}) // Onde pode ser usada
@Documented                                   // Incluir na documentação JavaDoc
public @interface MinhaAnnotation {
    String value();                // Elemento obrigatório
    int count() default 0;         // Elemento opcional com valor padrão
    String[] tags() default {};    // Array com valor padrão vazio
}
```

### Tipos de Elementos Permitidos
```java
public @interface ConfiguracaoCompleta {
    // Tipos primitivos
    int valor();
    boolean ativo();
    
    // String
    String descricao();
    
    // Class
    Class<?> tipo();
    
    // Enum
    NivelLog nivel() default NivelLog.INFO;
    
    // Annotation
    Override referencia() default @Override;
    
    // Arrays
    String[] tags();
}
```

### Valores Default
```java
public @interface Configuracao {
    // Valor único sem default (obrigatório)
    String nome();
    
    // Valor único com default (opcional)
    int timeout() default 1000;
    
    // Array com default vazio
    String[] perfis() default {};
    
    // Array com valores default
    String[] ambientes() default {"dev", "test"};
}
```

### Annotations Simples vs. Complexas

#### Annotation Simples (Marker)
```java
// Annotation marcadora - sem elementos
public @interface Auditavel {}

// Uso
@Auditavel
public class ContaBancaria {}
```

#### Annotation com Valor Único
```java
public @interface NomeTabela {
    String value();  // Elemento especial 'value'
}

// Uso simplificado
@NomeTabela("usuarios")
public class Usuario {}
```

#### Annotation Complexa
```java
public @interface Entidade {
    String nome();
    String schema() default "";
    boolean auditavel() default false;
    String[] indices() default {};
}

// Uso
@Entidade(
    nome = "produtos",
    schema = "estoque",
    auditavel = true,
    indices = {"idx_nome", "idx_codigo"}
)
public class Produto {}
```

### Annotations Aninhadas
```java
// Annotation interna
public @interface Coluna {
    String nome();
    boolean nullable() default true;
}

// Annotation container
public @interface Colunas {
    Coluna[] value();
}

// Uso
@Colunas({
    @Coluna(nome = "id", nullable = false),
    @Coluna(nome = "nome")
})
public class Exemplo {}
```

### Processamento de Annotations Customizadas
```java
public class ProcessadorAnnotation {
    public void processar(Class<?> classe) {
        // Verificando se a classe tem a annotation
        if (classe.isAnnotationPresent(MinhaAnnotation.class)) {
            // Obtendo a annotation
            MinhaAnnotation annotation = 
                classe.getAnnotation(MinhaAnnotation.class);
            
            // Acessando elementos
            String valor = annotation.value();
            int contador = annotation.count();
            String[] tags = annotation.tags();
            
            // Processamento...
        }
    }
}
```

### Exemplo Completo
```java
// Definição da annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServicoRest {
    String path();
    String versao() default "1.0";
    MetodoHttp[] metodos() default {};
    
    public enum MetodoHttp {
        GET, POST, PUT, DELETE
    }
}

// Uso da annotation
@ServicoRest(
    path = "/usuarios",
    versao = "2.0",
    metodos = {
        ServicoRest.MetodoHttp.GET,
        ServicoRest.MetodoHttp.POST
    }
)
public class UsuarioController {
    // Implementação...
}

// Processamento
public class ServicoRestScanner {
    public void scanearServicos(String pacote) {
        // Lógica para encontrar classes no pacote
        Class<?>[] classes = // ...
        
        for (Class<?> classe : classes) {
            if (classe.isAnnotationPresent(ServicoRest.class)) {
                ServicoRest servico = 
                    classe.getAnnotation(ServicoRest.class);
                
                // Registrar endpoint
                registrarEndpoint(
                    servico.path(),
                    servico.versao(),
                    servico.metodos()
                );
            }
        }
    }
    
    private void registrarEndpoint(
        String path, 
        String versao, 
        MetodoHttp[] metodos
    ) {
        // Implementação do registro...
    }
}
```

## Uso de Anotações

### Em Classes
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String name;
}
```

### Em Métodos
```java
@Test
@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public void testMethod() {
    // Test implementation
}
```

## Processamento de Anotações

### Em Tempo de Compilação
```java
@SupportedAnnotationTypes("com.example.annotations.*")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class MyAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Processamento
        return true;
    }
}
```

### Em Tempo de Execução
```java
public class AnnotationReader {
    public void readAnnotations(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                System.out.println("Test: " + test.value());
            }
        }
    }
}
```

## Padrões de Uso

### Validação
```java
@NotNull
@Size(min = 5, max = 50)
private String username;

@Email
@NotBlank
private String email;
```

### Configuração
```java
@Configuration
@EnableCaching
public class AppConfig {
    @Bean
    @Scope("singleton")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
```

## Boas Práticas

### Nomenclatura
- Nomes descritivos
- Convenções consistentes
- Documentação clara

### Design
- Mantenha simples
- Evite duplicação
- Use valores default apropriados

## Exemplos Avançados

### Anotações Repetíveis
```java
@Repeatable(Roles.class)
public @interface Role {
    String value();
}

public @interface Roles {
    Role[] value();
}

@Role("ADMIN")
@Role("USER")
public class UserController { }
```

### Anotações Compostas
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringBootApplication
@EnableCaching
@EnableScheduling
public @interface MyApplication { }
```

## Casos de Uso

### Framework de Teste
```java
@Test
@DisplayName("Teste de soma")
@Tag("math")
public void testAdd() {
    assertEquals(4, Calculator.add(2, 2));
}
```

### Injeção de Dependência
```java
@Component
public class UserService {
    @Autowired
    private UserRepository repository;
    
    @Transactional
    public void saveUser(User user) {
        repository.save(user);
    }
}
```

## Recursos Adicionais

### Documentação
- Java Annotation Specification
- Tutorial Oracle sobre Annotations
- Processadores de Anotação

### Frameworks
- Spring Annotations
- JUnit Annotations
- Jakarta EE Annotations