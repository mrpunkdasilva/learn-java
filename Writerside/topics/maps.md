# Maps: O Guarda-Volumes da Matrix

```ascii
MAP TYPES
├── HashMap (Armário Digital)
├── LinkedHashMap (Armário com Histórico)
└── TreeMap (Armário Ordenado)
```

## Fundamentos

Maps são como um guarda-volumes high-tech - cada item tem sua chave única, e você pode guardar qualquer coisa lá dentro.

```java
// Criando um guarda-volumes digital
Map<String, String> lockers = new HashMap<>();
lockers.put("A123", "Katana Digital");    // Guarda item
lockers.get("A123");                      // Recupera item
```

## Tipos de Maps (Diferentes Sistemas)

### HashMap (Armário Quantum)
```java
// Rápido e aleatório, como teletransporte
HashMap<Integer, String> quantum = new HashMap<>();
quantum.put(42, "Dados Encriptados");  // Ordem? Irrelevante!
quantum.put(7, "Código Fonte");        // Acesso instantâneo
```

### LinkedHashMap (Registro Cronológico)
```java
// Mantém ordem de inserção, como log de sistema
LinkedHashMap<String, String> logs = new LinkedHashMap<>();
logs.put("09:00", "Login");    // Primeiro registro
logs.put("09:01", "Download"); // Segundo registro
```

### TreeMap (Mainframe Ordenado)
```java
// Sempre ordenado pela chave, como diretório indexado
TreeMap<String, String> mainframe = new TreeMap<>();
mainframe.put("sys.exe", "Sistema");     // Ordenação
mainframe.put("hack.exe", "Ferramentas"); // automática
```

## Operações Básicas (Protocolos de Acesso)

### Inserção (Upload)
```java
Map<String, Object> database = new HashMap<>();
database.put("user.dat", new User());          // Novo registro
database.putIfAbsent("backup.dat", new Data()); // Só se não existir
```

### Recuperação (Download)
```java
// Diferentes formas de acessar
Object data = database.get("user.dat");        // Acesso direto
Object safe = database.getOrDefault("temp.dat", new Data()); // Com fallback
```

### Remoção (Delete)
```java
// Limpando registros
database.remove("temp.dat");              // Remove entrada
database.remove("user.dat", oldUser);     // Remove se valor bater
```

## Navegação (Scanning)

```java
Map<String, String> matrix = new HashMap<>();

// Iterando chaves (Scanning IDs)
for (String key : matrix.keySet()) {
    System.out.println("ID: " + key);
}

// Iterando valores (Data Mining)
for (String value : matrix.values()) {
    System.out.println("Data: " + value);
}

// Iterando pares (Full Scan)
for (Map.Entry<String, String> entry : matrix.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

## Operações Avançadas (Hacks)

```java
// Computação condicional
matrix.compute("stats", (k, v) -> v == null ? "new" : v + "_updated");

// Merge de dados
matrix.merge("downloads", 1, (old, new) -> old + new);

// Operações em massa
matrix.replaceAll((k, v) -> v.toUpperCase());
```

## Dicas de Segurança

1. **Escolha do Sistema**
   - HashMap: Para acesso rápido e aleatório
   - LinkedHashMap: Quando ordem de inserção importa
   - TreeMap: Para manter chaves ordenadas

2. **Performance**
```java
// Inicialize com tamanho se souber
Map<String, String> system = new HashMap<>(100);

// Use o tipo certo para cada operação
Map<String, Integer> sorted = new TreeMap<>();  // Para dados ordenados
```

## Exercícios Práticos

1. Implemente um sistema de cache
2. Crie um gerenciador de sessões
3. Desenvolva um contador de frequência

## Próximos Passos

Depois de dominar os Maps, você estará pronto para:

1. Criar sistemas de armazenamento chave-valor
2. Implementar caches eficientes
3. Gerenciar dados indexados

[Sets: Exclusividade](sets.md){.previous-step}
[Queues: Processamento](queues.md){.next-step}

---

> "Maps são como o guarda-volumes da Matrix - cada segredo tem sua chave, e só você sabe onde procurar!"