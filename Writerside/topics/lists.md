# Lists: A Playlist do Baile Funk

```ascii
LIST TYPES
├── ArrayList (Camarote VIP)
└── LinkedList (Fila do Open Bar)
```

## Fundamentos

Lists são como uma festa funk - tem ordem, repetição e sempre cabe mais um. 

```java
// Criando a lista de convidados
List<String> convidados = new ArrayList<>();
convidados.add("MC Kevinho");    // Adiciona no fim da lista
convidados.add(0, "MC Livinho"); // Fura a fila (adiciona no início)
```

## ArrayList vs LinkedList

### ArrayList (Camarote VIP)
```java
// Rápido pra achar alguém, como camarote numerado
ArrayList<String> camarote = new ArrayList<>();
camarote.add("Anitta");
camarote.get(0);         // Acesso direto, mesa 0
```

### LinkedList (Fila do Open Bar)
```java
// Melhor pra galera entrar e sair, como fila de open bar
LinkedList<String> openBar = new LinkedList<>();
openBar.addFirst("Sedento");   // Furando fila
openBar.addLast("Paciente");   // Entrando no fim
```

## Operações Básicas (Como Gerenciar o Baile)

### Adição (Deixa Entrar)
```java
// Vários jeitos de deixar a galera entrar
List<String> baile = new ArrayList<>();
baile.add("Dançarino");           // Fim da fila
baile.add(0, "DJ");               // VIP, direto pro início
baile.addAll(Arrays.asList("MC", "DJ", "Beat Maker")); // Grupo
```

### Remoção (Expulsando da Festa)
```java
// Diferentes formas de expulsar
baile.remove("Confusão");          // Remove elemento específico
baile.remove(0);                   // Remove da posição
baile.removeIf(x -> x.contains("Briga")); // Remove todos briguentos
```

### Acesso (Procurando na Multidão)
```java
// Encontrando a galera
String vip = baile.get(0);         // Pega pela posição
int pos = baile.indexOf("DJ");     // Onde tá o DJ?
boolean temMC = baile.contains("MC"); // O MC chegou?
```

## Lists Especializadas (Áreas VIP)

### Vector (Antiga Casa de Show)
```java
// Synchronized por padrão, como segurança old school
Vector<String> casaAntiga = new Vector<>();
casaAntiga.add("Dançarino Clássico");
```

### Stack (Pilha de Caixas de Som)
```java
// LIFO - Last In, First Out
Stack<String> equipamento = new Stack<>();
equipamento.push("Grave");     // Empilha
String topo = equipamento.pop(); // Desempilha
```

## Ordenação (Organizando o Line-up)

```java
// Ordenando a lista de apresentações
List<String> lineup = new ArrayList<>();
lineup.addAll(Arrays.asList("MC Late", "DJ Early", "MC Prime"));

// Ordem alfabética
Collections.sort(lineup);

// Ordem personalizada
lineup.sort((a, b) -> a.length() - b.length()); // Por tamanho do nome
```

## Iteração (Passando o Som)

```java
// For tradicional (Contagem regressiva)
for (int i = 0; i < lineup.size(); i++) {
    System.out.println("Próximo: " + lineup.get(i));
}

// For each (Passando o som)
for (String artista : lineup) {
    System.out.println("No palco: " + artista);
}

// Iterator (Revista na entrada)
Iterator<String> revista = lineup.iterator();
while (revista.hasNext()) {
    String pessoa = revista.next();
    if (pessoa.contains("Problema")) {
        revista.remove(); // Barrado
    }
}
```

## Dicas Pro Baile

1. **Escolha Certa**
   - ArrayList: Quando precisa acessar rápido
   - LinkedList: Quando a galera entra e sai muito

2. **Performance**
```java
// Define o tamanho se souber quantos vem
List<String> convidados = new ArrayList<>(100);

// Limpa a lista depois da festa
convidados.clear();
```

## Exercícios Práticos

1. Implemente um sistema de fila de entrada
2. Crie um gerenciador de playlists
3. Desenvolva um controlador de pedidos de música

## Próximos Passos

Depois de dominar as Lists, você estará pronto para:

1. Gerenciar qualquer tipo de sequência ordenada
2. Implementar filas e pilhas eficientes
3. Organizar dados com repetição

[Collections Overview](collections-overview.md){.previous-step}
[Sets: Sem Repeteco](sets.md){.next-step}

---

> "Lists são como um baile funk: tem ordem, aceita repetição e sempre cabe mais um na pista!"