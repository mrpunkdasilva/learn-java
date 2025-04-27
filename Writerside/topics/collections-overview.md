# Collections Framework: O Submundo das Estruturas de Dados

```ascii
COLLECTIONS HIERARCHY
├── List (Como uma Lista de Devedores)
├── Set (Clube Exclusivo, Sem Repetidos)
├── Queue (Fila do Pão, Mas Com Classe)
└── Map (Agenda Telefônica do Traficante)
```

## Anatomia do Submundo

Imagine o Collections Framework como uma organização criminosa bem estruturada - cada família tem sua especialidade, mas todas trabalham juntas quando necessário.

```java
// As principais famílias
List<String> listaDaChantagem = new ArrayList<>();
Set<String> membrosVIP = new HashSet<>();
Queue<String> filaDeEspera = new LinkedList<>();
Map<String, Double> contasAReceber = new HashMap<>();
```

## Famílias Principais

### 1. List (A Lista Negra)
```java
List<String> alvos = new ArrayList<>();
alvos.add("João Caloteiro");    // Adiciona no final
alvos.add(0, "Maria Malandra"); // Adiciona no início
String proximo = alvos.get(0);  // Próxima vítima
```

### 2. Set (Clube dos Exclusivos)
```java
Set<String> vips = new HashSet<>();
vips.add("Don Corleone");     // Entra no clube
vips.add("Don Corleone");     // Tenta entrar de novo (falha)
boolean isMembro = vips.contains("Don Corleone"); // Tá na lista?
```

### 3. Queue (Fila do Desespero)
```java
Queue<String> esperando = new LinkedList<>();
esperando.offer("Zé Devedor");  // Entra na fila
String proximo = esperando.poll(); // Próximo a ser "atendido"
String espiadinha = esperando.peek(); // Quem é o próximo sem tirar
```

### 4. Map (Livro Caixa)
```java
Map<String, Double> dividas = new HashMap<>();
dividas.put("Zé", 1000.0);     // Deve mil
dividas.put("Maria", 2000.0);   // Deve dois mil
Double quanto = dividas.get("Zé"); // Quanto o Zé deve?
```

## Escolhendo sua Arma

### ArrayList vs LinkedList
```java
// ArrayList: Acesso rápido, como endereço fixo
List<String> enderecos = new ArrayList<>();  // Ótimo para consultas

// LinkedList: Inserção rápida, como mensageiro
List<String> mensagens = new LinkedList<>();  // Bom para alterações
```

### HashSet vs TreeSet
```java
// HashSet: Rápido e caótico, como bar de porto
Set<String> frequentadores = new HashSet<>();  // Não liga pra ordem

// TreeSet: Organizado e lento, como clube de madame
Set<String> clientesVIP = new TreeSet<>();     // Tudo ordenadinho
```

### HashMap vs TreeMap
```java
// HashMap: Bagunçado mas eficiente, como caderno de agiota
Map<String, Double> pagamentos = new HashMap<>();

// TreeMap: Organizado e metódico, como livro contábil
Map<String, Double> contabilidade = new TreeMap<>();
```

## Operações Especiais

### Iteração (Fazendo a Ronda)
```java
// For each moderno
for (String devedor : alvos) {
    System.out.println("Procurando: " + devedor);
}

// Iterator (modo old school)
Iterator<String> it = alvos.iterator();
while (it.hasNext()) {
    String alvo = it.next();
    if (alvo.contains("Delator")) {
        it.remove(); // Remove o X9
    }
}
```

### Ordenação (Organizando a Casa)
```java
// Ordenar a lista de devedores por nome
Collections.sort(alvos);

// Ordenar por valor da dívida
alvos.sort((a, b) -> dividas.get(a).compareTo(dividas.get(b)));
```

## Dicas de Sobrevivência

1. **Escolha Certa**
   - ArrayList para acesso rápido
   - LinkedList para muitas alterações
   - HashSet para unicidade
   - TreeSet para ordem natural
   - HashMap para acesso por chave
   - TreeMap para ordem nas chaves

2. **Performance**
```java
// Defina o tamanho inicial se souber
List<String> lista = new ArrayList<>(1000);

// Use a estrutura certa pro trabalho
Set<String> conjunto = new HashSet<>();  // Mais rápido que List pra busca
```

## Exercícios Práticos

1. Implemente um sistema de controle de território
2. Crie um gerenciador de dívidas com juros compostos
3. Desenvolva uma lista de "proteção" com prioridades

## Próximos Passos

Depois de dominar as Collections, você estará pronto para:

1. Gerenciar dados como um profissional
2. Implementar estruturas complexas
3. Otimizar operações de dados

[Arrays: De Volta ao Básico](arrays.md){.previous-step}
[Lists: Quando a Ordem Importa](lists.md){.next-step}

---

> "Collections são como uma família do crime organizado - cada uma tem seu papel, e juntas controlam toda a cidade dos dados."