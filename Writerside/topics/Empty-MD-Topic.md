# 2. Sintaxe Básica

Neste capítulo, vamos explorar os fundamentos da sintaxe Java, desde a estrutura básica de um programa até os operadores mais comuns. Esses conceitos são essenciais para começar a programar em Java.

---

#### **2.1 Estrutura de um Programa Java**
Todo programa Java começa com uma **classe** e um **método principal** (`main`). Aqui está um exemplo simples:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

- **Classe (`Main`):** Todo programa Java é organizado em classes. O nome da classe deve corresponder ao nome do arquivo (`Main.java`).
- **Método `main`:** É o ponto de entrada do programa. O Java procura por esse método para começar a execução.
- **`System.out.println`:** Usado para imprimir texto no console.

---


#### **2.2 Tipos de Dados**
Java possui dois tipos de dados principais: **primitivos** e **de referência**.

- **Tipos Primitivos:**
  - `int`: Números inteiros (ex: `int idade = 25;`).
  - `double`: Números decimais (ex: `double altura = 1.75;`).
  - `char`: Um único caractere (ex: `char letra = 'A';`).
  - `boolean`: Valores verdadeiros ou falsos (ex: `boolean isJavaFun = true;`).

- **Tipos de Referência:**
  - `String`: Sequência de caracteres (ex: `String nome = "Java";`).
  - `Arrays`: Coleção de elementos do mesmo tipo (ex: `int[] numeros = {1, 2, 3};`).
  - Objetos: Instâncias de classes.

---

#### **2.3 Variáveis e Convenções de Nomes**
- **Declaração de Variáveis:**
  - Sintaxe: `tipo nome = valor;` (ex: `int numero = 10;`).
  - Variáveis devem ser declaradas antes de serem usadas.

- **Convenções de Nomes:**
  - Use `camelCase` para nomes de variáveis e métodos (ex: `idadeDoUsuario`).
  - Use `PascalCase` para nomes de classes (ex: `Calculadora`).
  - Constantes devem ser em `UPPER_CASE` (ex: `PI = 3.14;`).

---

#### **2.4 Operadores**
Java possui vários tipos de operadores para realizar operações em variáveis e valores.

- **Operadores Aritméticos:**
  - `+` (adição), `-` (subtração), `*` (multiplicação), `/` (divisão), `%` (módulo).
  - Exemplo: `int soma = 10 + 5;`.

- **Operadores de Comparação:**
  - `==` (igual), `!=` (diferente), `>` (maior), `<` (menor), `>=` (maior ou igual), `<=` (menor ou igual).
  - Exemplo: `boolean isMaior = 10 > 5;`.

- **Operadores Lógicos:**
  - `&&` (E lógico), `||` (OU lógico), `!` (NÃO lógico).
  - Exemplo: `boolean resultado = (10 > 5) && (20 < 30);`.


##### **Tabela de Operadores em Java**

| **Categoria**         | **Operador** | **Descrição**                                                                 | **Exemplo**                          |
|------------------------|--------------|-------------------------------------------------------------------------------|--------------------------------------|
| **Aritméticos**        | `+`          | Adição                                                                       | `int soma = 10 + 5;`                 |
|                        | `-`          | Subtração                                                                    | `int diferenca = 10 - 5;`            |
|                        | `*`          | Multiplicação                                                                | `int produto = 10 * 5;`              |
|                        | `/`          | Divisão                                                                      | `double quociente = 10.0 / 3.0;`     |
|                        | `%`          | Módulo (resto da divisão)                                                    | `int resto = 10 % 3;`                |
| **Atribuição**         | `=`          | Atribuição simples                                                           | `int x = 10;`                        |
|                        | `+=`         | Atribuição com adição                                                        | `x += 5;` (equivale a `x = x + 5;`)  |
|                        | `-=`         | Atribuição com subtração                                                     | `x -= 3;` (equivale a `x = x - 3;`)  |
|                        | `*=`         | Atribuição com multiplicação                                                 | `x *= 2;` (equivale a `x = x * 2;`)  |
|                        | `/=`         | Atribuição com divisão                                                       | `x /= 2;` (equivale a `x = x / 2;`)  |
|                        | `%=`         | Atribuição com módulo                                                        | `x %= 3;` (equivale a `x = x % 3;`)  |
| **Comparação**         | `==`         | Igual a                                                                      | `boolean isIgual = (10 == 5);`       |
|                        | `!=`         | Diferente de                                                                 | `boolean isDiferente = (10 != 5);`   |
|                        | `>`          | Maior que                                                                    | `boolean isMaior = (10 > 5);`        |
|                        | `<`          | Menor que                                                                    | `boolean isMenor = (10 < 5);`        |
|                        | `>=`         | Maior ou igual a                                                             | `boolean isMaiorOuIgual = (10 >= 5);`|
|                        | `<=`         | Menor ou igual a                                                             | `boolean isMenorOuIgual = (10 <= 5);`|
| **Lógicos**            | `&&`         | E lógico (AND)                                                               | `boolean resultado = (10 > 5) && (20 < 30);` |
|                        | `||`         | OU lógico (OR)                                                               | `boolean resultado = (10 > 5) || (20 < 30);` |
|                        | `!`          | NÃO lógico (NOT)                                                             | `boolean isNotTrue = !(10 > 5);`     |
| **Incremento/Decremento** | `++`      | Incremento (adiciona 1)                                                      | `x++;` (equivale a `x = x + 1;`)     |
|                        | `--`         | Decremento (subtrai 1)                                                       | `x--;` (equivale a `x = x - 1;`)     |
| **Ternário**           | `? :`        | Operador ternário (if-else em uma linha)                                     | `int maior = (10 > 5) ? 10 : 5;`     |



---

#### **2.5 Arrays**
Arrays são estruturas de dados que permitem armazenar múltiplos valores do mesmo tipo em uma única variável.

- **Declaração de Arrays:**
  - Sintaxe: `tipo[] nomeArray;` (ex: `int[] numeros;`).
  - Inicialização: `nomeArray = new tipo[tamanho];` (ex: `numeros = new int[5];`).

- **Acessando Elementos do Array:**
  - Use o índice do elemento entre colchetes (ex: `numeros[0] = 10;`).
  - O índice começa em 0.

- **Percorrendo um Array:**
  - Você pode usar um loop `for` para percorrer todos os elementos do array.
  - Exemplo:
    ```java
    for (int i = 0; i < numeros.length; i++) {
        System.out.println(numeros[i]);
    }
    ```

---

#### **2.6 Matrizes**
Matrizes são arrays bidimensionais, ou seja, arrays de arrays.

- **Declaração de Matrizes:**
  - Sintaxe: `tipo[][] nomeMatriz;` (ex: `int[][] matriz;`).
  - Inicialização: `nomeMatriz = new tipo[linhas][colunas];` (ex: `matriz = new int[3][4];`).

- **Acessando Elementos da Matriz:**
  - Use o índice da linha e da coluna entre colchetes (ex: `matriz[1][2] = 10;`).
  - O índice começa em 0.

- **Percorrendo uma Matriz:**
  - Você pode usar dois loops `for` aninhados para percorrer todos os elementos da matriz.
  - Exemplo:
    ```java
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.println(matriz[i][j]);
        }
    }
    ```

---

#### **2.7 Strings**
Strings são sequências de caracteres que representam texto.

- **Declaração de Strings:**
  - Sintaxe: `String nomeString;` (ex: `String nome;`).
  - Inicialização: `nomeString = "Hello, World!";` (ex: `nome = "Java";`).

- **Operações com Strings:**
  - Concatenação: Use o operador `+` para combinar duas strings (ex: `String saudacao = "Olá, " + nome + "!";`).
  - Comparação: Use os operadores de comparação (`==` e `!=`) para comparar strings (ex: `boolean isIgual = nome.equals("Java");`).
  - Métodos úteis: Existem vários métodos para manipular e extrair informações de strings, como `length()`, `charAt()`, `substring()`, etc.

---

#### **2.8 Entrada e Saída de Dados**
Java fornece várias maneiras de ler e escrever dados de entrada e saída.

- **Entrada de Dados:**
  - Você pode usar a classe `Scanner` para ler dados de entrada do usuário.
  - Exemplo:
    ```java
    import java.util.Scanner;

    public class EntradaSaida {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Olá, " + nome + "!");
        }
    }
    ```

- **Saída de Dados:**
  - Você pode usar a classe `System.out` para escrever dados na saída padrão (console).
  - Exemplo:
    ```java
    System.out.println("Hello, World!");
    System.out.print("Digite seu nome: ");
    System.out.printf("Olá, %s!\n", nome);
    ```

---

#### **2.9 Comentários**
Comentários são usados para explicar o código e torná-lo mais legível.

- **Comentários de Linha:**
  - Sintaxe: `// Texto do comentário` (ex: `// Este é um comentário de linha`).
  - O texto após `//` até o final da linha é considerado um comentário.

- **Comentários de Bloco:**
  - Sintaxe: `/* Texto do comentário */` (ex: `/* Este é um comentário de bloco */`).
  - O texto entre `/*` e `*/` é considerado um comentário.

---


#### **2.10 Revisão**
- Sintaxe básica do Java: tipos de dados, variáveis, operadores, estruturas de controle (condicionais e loops), arrays, matrizes, strings, entrada e saída de dados, comentários.
- Exercícios para praticar e revisar os conhecimentos adquiridos.

---

#### **2.11 Próximos Passos**
- No próximo capítulo, você aprenderá sobre **estruturas de controle avançadas**, como switch-case e operadores ternários.
- Em seguida, você explorará **métodos e classes**, aprendendo a organizar seu código em funções e objetos.
- Depois disso, você estudará **herança e polimorfismo**, que permitem criar hierarquias de classes e implementar comportamentos específicos para objetos.
- Por fim, você aprenderá sobre **exceções**, que permitem tratar erros e anomalias em seu código.
