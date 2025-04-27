# Arrays em Java

```ascii
ARRAY OPERATIONS
├── Declaração (Como registrar clientes em um bordel)
├── Inicialização (Abrir as portas)
├── Acesso (Encontrar seu favorito)
├── Modificação (Trocar os números)
└── Iteração (Fazer a ronda noturna)
```

## Fundamentos

Arrays são como um bordel bem organizado - cada quarto tem seu número, e você sabe exatamente o que esperar em cada um. Sem surpresas desagradáveis.

```java
// Declaração e inicialização
int[] quartos = new int[5];  // 5 quartos vazios
String[] servicos = {"BASICO", "ESPECIAL", "COMPLETO"};

// Array multidimensional (como um prédio com vários andares)
int[][] predio = new int[3][3];
```

## Características Principais

### 1. Tamanho Fixo (Como um Motel Lotado)
```java
// Uma vez definido o número de quartos, não dá pra criar mais
int numQuartos = 10;
double[] precos = new double[numQuartos];

// Nem adianta chorar, não vai caber mais
System.out.println("Quartos disponíveis: " + precos.length);
```

### 2. Indexação Base-Zero (Como Idade de Político)
```java
// O primeiro sempre começa do zero
int primeiro = quartos[0];  // Quarto 0 (mas na placa tá 1)

// O último é sempre um a menos que o total
int ultimo = quartos[quartos.length - 1];
```

### 3. Tipo Homogêneo (Como Menu de Boteco)
```java
// Aqui só serve cachaça, amigo
String[] drinks = new String[3];
drinks[0] = "51";
drinks[1] = "Velho Barreiro";
drinks[2] = "Pitú";
```

## Operações Comuns

### Iteração (Como Fazer a Ronda)
```java
// Método tradicional (checando quarto por quarto)
for (int i = 0; i < quartos.length; i++) {
    System.out.println("Verificando quarto " + i);
}

// Método moderno (câmeras de segurança)
for (String drink : drinks) {
    System.out.println("Bebida disponível: " + drink);
}
```

### Manipulação (Como Gerenciar o Estabelecimento)
```java
// Resetar preços (promoção de segunda)
Arrays.fill(precos, 29.90);

// Ordenar por preço (do mais barato pro mais caro)
Arrays.sort(precos);

// Procurar aquele cliente especial
int indice = Arrays.binarySearch(drinks, "51");
```

## Arrays Multidimensionais (Como um Cassino de Luxo)

### Matrizes
```java
// Mapa do cassino (3 andares, cada um com 3 salas)
int[][] cassino = {
    {1, 2, 3},  // Caça-níqueis
    {4, 5, 6},  // Poker
    {7, 8, 9}   // Roleta
};

// Encontrar mesa específica
int mesa = cassino[1][2];  // Mesa 6 de poker
```

### Iteração em Matrizes (Inspeção Sanitária)
```java
// Verificando todas as mesas
for (int andar = 0; andar < cassino.length; andar++) {
    for (int sala = 0; sala < cassino[andar].length; sala++) {
        System.out.print("Verificando mesa " + cassino[andar][sala]);
    }
    System.out.println(" - Andar limpo!");
}
```

## Boas Práticas (Regras da Casa)

1. **Validação de Índices (Checagem de ID)**
```java
if (quarto >= 0 && quarto < quartos.length) {
    // Cliente pode entrar
    return quartos[quarto];
}
```

2. **Cópia de Arrays (Expandindo o Negócio)**
```java
// Abrindo filial com mesma configuração
int[] filial = Arrays.copyOf(quartos, quartos.length);

// Pegando só o melhor da casa
int[] vips = Arrays.copyOfRange(quartos, 1, 4);
```

## Exercícios Práticos

1. Implemente um sistema de rodízio de "funcionários"
2. Crie um controle de mesas de poker
3. Desenvolva um algoritmo de distribuição de gorjetas

## Próximos Passos

Depois de dominar esse bordel de arrays, você estará pronto para:

1. Gerenciar uma rede de estabelecimentos
2. Implementar sistemas de fidelidade
3. Expandir para o mercado internacional

[Collections: Quando Um Não é Suficiente](collections-overview.md){.next-step}

---

> "Arrays são como um bordel bem administrado - cada elemento no seu lugar, e você sempre sabe onde encontrar o que procura."
