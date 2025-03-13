# 🔌 Portas Lógicas

Os computadores são constituídos de elementos eletrônicos como: **capacitores**, **resistores** e **transistores**.

- **Capacitores:** são os componentes responsáveis por armazenar e liberar carga elétrica, sendo que realizam a filtragem de ruído e a estabilização de tensões.

- **Resistores:** limitam a passagem de corrente elétrica, são usados para controlar a voltagem da corrente elétrica.

- **Transistores:** amplificam sinais e controlam o fluxo da corrente dentro do circuito. Eles permitem ou não a passagem de binários para realizarem operações através das portas lógicas, e tudo isso forma os `circuitos lógicos`.

Portas Lógicas são a base para a construção de um processador. Elas são embutidas em um CI (Circuito Integrado) com o objetivo de realizar tarefas específicas. Podem ser encontradas tanto em **ULSI (Ultra Larga Escala Integrada)** quanto em circuitos mais simples.

---

## Álgebra de Comutação
Assim como a álgebra básica da escola, criou-se a necessidade de fazer operações com os dígitos binários. Surge então a **Álgebra de Comutação**.

Para tal, era necessário primeiro definir-se as representações gráficas e então se adotou 0 (falso) e 1 (verdadeiro).

### Porta AND
Esta porta aceita dois operandos: A e B, sendo binários 0 e 1. 
A operação AND simula a multiplicação binária, possuindo a finalidade de garantir que o mesmo bit de entrada seja o mesmo da saída (transferência de bit, ou seja, é usado para transferir dados da memória para a CPU).

- Porta Lógica **AND**:

| Entrada | Saída |        |
| ------- | ----- | ------ |
| A       | B     | Y = AB |
| 1       | 0     | 0      |
| 0       | 1     | 0      |
| 1       | 1     | 1      |
| 0       | 0     | 0      |

### Porta OR
Esta porta aceita dois operandos: A e B, sendo binários 0 e 1.
Ela simula a soma binária, ou seja, só resultará em verdadeiro (1) se um dos operandos for igual a 1.

- Porta Lógica **OR**:

| Entrada | Saída |         |
| ------- | ----- | ------- |
| A       | B     | Y = A+B |
| 1       | 0     | 1       |
| 0       | 1     | 1       |
| 1       | 1     | 1       |
| 0       | 0     | 0       |

###  Porta XOR (exclusive or)
Esta porta aceita dois operandos: A e B, sendo binários 0 e 1.
Ela serve como uma verificação de igualdade, em que se os operandos tiverem os seus valores binários diferentes, a operação resultará em verdadeiro (1). Caso contrário, resultará em falso (0).

- Porta Lógica **XOR**:

| Entrada | Saída |             |
| ------- | ----- | ----------- |
| A       | B     | Y = A XOR B |
| 1       | 1     | 0           |
| 0       | 1     | 1           |
| 1       | 0     | 1           |
| 0       | 0     | 0           |

---

### Porta NOT
Esta porta aceita um operando: A, sendo binário 0 ou 1.
Ela faz uma inversão de valores, ou seja, se o valor do operando for 1, ele se torna 0, e se for 0, ele se torna 1.

- Porta Lógica **NOT**:

| Entrada | Saída |
| ------- | ----- |
| A       | NOT A |
| 1       | 0     |
| 0       | 1     |

###  Portas Derivadas
> A execução dessas portas se dá por uma de cada vez, ou seja, irá executar primeiro uma e depois a outra.

###  Porta NAND
Esta porta aceita dois operandos: A e B, sendo binários 0 e 1.
Ela faz a operação AND e em seguida realiza a execução do NOT.

- Porta Lógica **NAND**:

| Entrada | Saída |              |
| ------- | ----- | ------------ |
| A       | B     | Y = A NAND B |
| 1       | 0     | 1            |
| 0       | 1     | 1            |
| 1       | 1     | 0            |
| 0       | 0     | 1            |

###  Porta NOR
Esta porta aceita dois operandos: A e B, sendo binários 0 e 1.
Ela faz primeiro o OR e em seguida opera o NOT.

- Porta Lógica **NOR**:

| Entrada |     | Saída   |
| ------- | --- | ------- |
| A       | B   | Y = A+B |
| 1       | 0   | 0       |
| 0       | 1   | 0       |
| 1       | 1   | 0       |
| 0       | 0   | 1       |
