# Sets: O Clube dos Únicos

```ascii
SET TYPES
├── HashSet (Balada Alternativa)
├── LinkedHashSet (Festa Temática)
└── TreeSet (Clube da Alta Sociedade)
```

## Fundamentos

Sets são como uma festa exclusiva - não tem repetido e cada um é único.

```java
// Criando a lista do clube mais exclusivo
Set<String> clubeDosUnicos = new HashSet<>();
clubeDosUnicos.add("Hipster");    // Entra
clubeDosUnicos.add("Hipster");    // Barrado! Já tem um igual
```

## Tipos de Sets (Diferentes Baladas)

### HashSet (Balada Alternativa)
```java
// Rápido e caótico, como uma rave
HashSet<String> rave = new HashSet<>();
rave.add("Raver");      // Ordem? Que ordem?
rave.add("DJ");         // Entra onde der
```

### LinkedHashSet (Festa Temática)
```java
// Mantém a ordem de entrada, como fila organizada
LinkedHashSet<String> tematica = new LinkedHashSet<>();
tematica.add("Anos 80");  // Primeiro
tematica.add("Anos 90");  // Segundo
```

### TreeSet (Clube da Alta Sociedade)
```java
// Sempre ordenado, como lista de socialites
TreeSet<String> clubeSocial = new TreeSet<>();
clubeSocial.add("Baronesa");   // Será ordenado
clubeSocial.add("Condessa");   // Automaticamente
```

## Operações Básicas (Regras do Clube)

### Adição (Tentando Entrar)
```java
Set<String> clube = new HashSet<>();
clube.add("Sócio");            // Bem-vindo ao clube
clube.add("Sócio");            // Negado! Já é membro
clube.addAll(Arrays.asList("VIP", "Premium")); // Grupo VIP
```

### Remoção (Cancelando Sociedade)
```java
// Diferentes formas de expulsar
clube.remove("Ex-sócio");       // Remove específico
clube.removeIf(x -> x.startsWith("Inadimplente")); // Remove todos inadimplentes
```

### Verificação (Lista na Porta)
```java
// Checando quem pode entrar
boolean isMembro = clube.contains("VIP");     // Está na lista?
boolean todosVIP = clube.containsAll(vips);   // Grupo inteiro na lista?
```

## Operações de Conjunto (Misturando as Tribos)

```java
Set<String> metaleiros = new HashSet<>();
Set<String> punks = new HashSet<>();

// União (Festa de Rock)
Set<String> rockeiros = new HashSet<>(metaleiros);
rockeiros.addAll(punks);

// Interseção (Amigos em Comum)
Set<String> hibridos = new HashSet<>(metaleiros);
hibridos.retainAll(punks);

// Diferença (Só Metaleiros)
Set<String> puristas = new HashSet<>(metaleiros);
puristas.removeAll(punks);
```

## Iteração (Fazendo a Social)

```java
// For each (Cumprimentando todo mundo)
for (String socio : clube) {
    System.out.println("Boa noite, " + socio);
}

// Iterator (Revista VIP)
Iterator<String> revista = clube.iterator();
while (revista.hasNext()) {
    String pessoa = revista.next();
    if (pessoa.contains("Indesejado")) {
        revista.remove(); // Tchau!
    }
}
```

## Dicas de Etiqueta

1. **Escolha do Clube**
   - HashSet: Quando só importa ser único
   - LinkedHashSet: Quando a ordem de entrada importa
   - TreeSet: Quando precisa manter tudo ordenado

2. **Performance**
```java
// Define tamanho inicial se souber
Set<String> vips = new HashSet<>(100);

// Use o tipo certo pra cada ocasião
Set<String> ordenados = new TreeSet<>();  // Sempre ordenado
```

## Exercícios Práticos

1. Implemente um sistema de controle de sócios
2. Crie um gerenciador de eventos exclusivos
3. Desenvolva um verificador de duplicatas

## Próximos Passos

Depois de dominar os Sets, você estará pronto para:

1. Gerenciar coleções sem duplicatas
2. Implementar sistemas de membros
3. Trabalhar com conjuntos matemáticos

[Lists: A Sequência](lists.md){.previous-step}
[Maps: Chave e Valor](maps.md){.next-step}

---

> "Sets são como clubes exclusivos - não importa quantas vezes você tente entrar, só passa uma vez!"