# Framework de Injeção de Dependências Customizado

## Visão Geral
Neste projeto, vamos desenvolver um mini-framework de injeção de dependências usando reflexão e anotações em Java. O framework oferecerá funcionalidades básicas de DI (Dependency Injection) e gerenciamento de ciclo de vida de componentes.

## Principais Características
- Injeção automática de dependências
- Gerenciamento de escopo (singleton/prototype)
- Configuração via anotações
- Inicialização e destruição de componentes
- Suporte a plugins

## Anotações do Framework

### @Component
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Component {
    String value() default "";
    String scope() default "singleton";
}
```

### @Inject
```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR})
public @interface Inject {
}
```

### @Initialize
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Initialize {
    int order() default 0;
}
```

## Container de Dependências

### Implementação Básica
```java
public class DIContainer {
    private Map<Class<?>, Object> singletons = new HashMap<>();
    private Map<Class<?>, Class<?>> bindings = new HashMap<>();

    public <T> void bind(Class<T> interfaceClass, Class<? extends T> implementationClass) {
        bindings.put(interfaceClass, implementationClass);
    }

    public <T> T getInstance(Class<T> type) {
        // Verifica se é singleton
        if (singletons.containsKey(type)) {
            return (T) singletons.get(type);
        }

        // Cria nova instância
        return createInstance(type);
    }

    private <T> T createInstance(Class<T> type) {
        try {
            Constructor<?> constructor = type.getDeclaredConstructor();
            T instance = (T) constructor.newInstance();
            injectDependencies(instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar instância", e);
        }
    }

    private void injectDependencies(Object instance) {
        Class<?> type = instance.getClass();
        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = getInstance(field.getType());
                try {
                    field.set(instance, dependency);
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao injetar dependência", e);
                }
            }
        }
    }
}
```

## Exemplo de Uso

### Definição de Componentes
```java
@Component
public class UserService {
    @Inject
    private UserRepository userRepository;
    
    @Initialize
    public void setup() {
        System.out.println("Inicializando UserService");
    }
    
    public User findUser(Long id) {
        return userRepository.findById(id);
    }
}

@Component(scope = "prototype")
public class UserRepository {
    private DatabaseConnection connection;
    
    @Inject
    public UserRepository(DatabaseConnection connection) {
        this.connection = connection;
    }
    
    public User findById(Long id) {
        // Implementação
        return null;
    }
}
```

### Configuração e Uso
```java
public class Application {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        
        // Configuração
        container.bind(UserRepository.class, UserRepositoryImpl.class);
        
        // Uso
        UserService userService = container.getInstance(UserService.class);
        User user = userService.findUser(1L);
    }
}
```

## Recursos Avançados

### Plugin System
```java
@Plugin
public interface UserPlugin {
    void onUserCreated(User user);
}

public class PluginManager {
    private List<UserPlugin> plugins = new ArrayList<>();
    
    public void registerPlugin(UserPlugin plugin) {
        plugins.add(plugin);
    }
    
    public void notifyUserCreated(User user) {
        plugins.forEach(plugin -> plugin.onUserCreated(user));
    }
}
```

### Aspect-Like Features
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {
}

public class TransactionInterceptor {
    public Object intercept(Method method, Object[] args) {
        beginTransaction();
        try {
            Object result = method.invoke(args);
            commitTransaction();
            return result;
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }
}
```

## Considerações de Design

### Padrões Utilizados
- Singleton para gerenciamento de instâncias
- Factory Method para criação de objetos
- Observer para sistema de plugins
- Proxy para interceptação de métodos

### Boas Práticas
- Lazy loading de dependências
- Cache de reflexão para performance
- Detecção de ciclos de dependência
- Logging e tratamento de erros

## Próximos Passos
1. Implementar suporte a profiles
2. Adicionar injeção por construtor
3. Desenvolver sistema de eventos
4. Criar mecanismo de configuração externa
5. Implementar lazy injection
