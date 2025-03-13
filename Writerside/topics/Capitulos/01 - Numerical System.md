# Sistema Numérico

## Sistema de Numeração e Conversões Entre Bases

### 1. Introdução

Os sistemas de numeração são ferramentas essenciais para representar quantidades e realizar cálculos matemáticos. No dia a dia, utilizamos predominantemente o sistema decimal, com base em 10 símbolos (0 a 9). No entanto, diversos outros sistemas de numeração foram desenvolvidos ao longo da história, cada um com suas características e aplicações específicas.

Neste artigo, exploraremos os principais sistemas de numeração utilizados: binário, octal e hexadecimal, além de abordar as técnicas de conversão entre eles.

### 2. Sistema Decimal

O sistema decimal é o mais utilizado no mundo, com base em 10 símbolos (0 a 9). Cada posição à direita do ponto decimal representa uma potência de 10. Por exemplo, no número 123,456:

* 1 na posição das centenas de milhar (10^5)
* 2 na posição das dezenas de milhar (10^4)
* 3 na posição das unidades de milhar (10^3)
* 4 na posição das centenas (10^2)
* 5 na posição das dezenas (10^1)
* 6 na posição das unidades (10^0)

### 3. Sistema Binário

O sistema binário utiliza apenas dois símbolos: 0 e 1. É amplamente utilizado na computação digital, pois representa diretamente os estados de um circuito eletrônico (ligado/desligado). Cada posição à direita do ponto binário representa uma potência de 2. Por exemplo, no número 101101:

* 1 na posição das unidades (2^0)
* 0 na posição das dezenas (2^1)
* 1 na posição das centenas (2^2)
* 1 na posição das unidades de milhar (2^3)
* 0 na posição das dezenas de milhar (2^4)
* 1 na posição das centenas de milhar (2^5)

### 4. Sistema Octal

O sistema octal utiliza 8 símbolos: 0 a 7. É menos comum que o sistema binário, mas ainda encontra aplicações em algumas áreas, como em permissões de arquivos em sistemas Unix. Cada posição à direita do ponto octal representa uma potência de 8. Por exemplo, no número 12345:

* 1 na posição das unidades (8^0)
* 3 na posição das dezenas (8^1)
* 4 na posição das centenas (8^2)
* 5 na posição das unidades de milhar (8^3)
* 2 na posição das dezenas de milhar (8^4)

### 5. Sistema Hexadecimal

O sistema hexadecimal utiliza 16 símbolos: 0 a 9 e A a F. É comumente utilizado em programação e eletrônica, pois permite representar grandes quantidades de dados de forma mais concisa. Cada posição à direita do ponto hexadecimal representa uma potência de 16. Por exemplo, no número 1F9A:

* A na posição das unidades (16^0)
* 9 na posição das dezenas (16^1)
* F na posição das centenas (16^2)
* 1 na posição das unidades de milhar (16^3)

### 6. Conversões Entre Bases

A conversão entre sistemas de numeração é essencial para trabalhar com diferentes representações de dados. Diversas técnicas podem ser utilizadas, como:

* **Conversão manual:** envolve cálculos passo a passo, utilizando as definições de cada sistema.
* **Calculadoras online:** ferramentas online podem realizar conversões entre bases de forma rápida e precisa.
* **Funções de conversão em linguagens de programação:** linguagens como Python possuem bibliotecas que facilitam a conversão entre bases.

### 7. Tabela de Conversão Resumida

| Decimal | Binário | Octal | Hexadecimal |
| ------- | ------- | ----- | ----------- |
| 0       | 0000    | 0     | 0           |
| 1       | 0001    | 1     | 1           |
| 2       | 0010    | 2     | 2           |
| 3       | 0011    | 3     | 3           |
| 4       | 0100    | 4     | 4           |
| 5       | 0101    | 5     | 5           |
| 6       | 0110    | 6     | 6           |
| 7       | 0111    | 7     | 7           |

---

Continuando a seção sobre conversões entre sistemas de numeração, apresentamos algumas técnicas para converter manualmente entre decimal, binário, octal e hexadecimal:

**A. Decimal para Binário:**

1. Divida o número decimal por 2.
2. Anote o resto da divisão (0 ou 1) como o bit menos significativo do número binário.
3. Divida o quociente da divisão anterior por 2 e repita os passos 1 e 2.
4. Continue dividindo por 2 e anotando os restos até o quociente se tornar 0.
5. Leia os restos da divisão na ordem inversa, do último para o primeiro. Essa é a representação binária do número decimal.

**Exemplo:** Converter 13 (decimal) para binário.

1. 13 / 2 = 6 (resto 1)
2. 6 / 2 = 3 (resto 0)
3. 3 / 2 = 1 (resto 1)
4. 1 / 2 = 0 (resto 1)

Lendo os restos na ordem inversa: 1101 (binário).

**B. Binário para Decimal:**

1. Cada bit na representação binária tem um peso equivalente a uma potência de 2 (começando em 2^0 para o bit menos significativo).
2. Multiplique cada bit pelo seu peso correspondente.
3. Some os resultados das multiplicações.

**Exemplo:** Converter 1011 (binário) para decimal.

1. 1 * 2^3 = 8
2. 0 * 2^2 = 0
3. 1 * 2^1 = 2
4. 1 * 2^0 = 1

Soma: 8 + 0 + 2 + 1 = 11 (decimal).

**C. Decimal para Octal:**

1. Divida o número decimal por 8.
2. Anote o resto da divisão como o dígito menos significativo do número octal.
3. Divida o quociente da divisão anterior por 8 e repita os passos 1 e 2.
4. Continue dividindo por 8 e anotando os restos até o quociente se tornar 0.
5. Leia os restos da divisão na ordem inversa, do último para o primeiro. Essa é a representação octal do número decimal.

**D. Octal para Decimal:**

1. Cada dígito na representação octal tem um peso equivalente a uma potência de 8 (começando em 8^0 para o dígito menos significativo).
2. Multiplique cada dígito pelo seu peso correspondente.
3. Some os resultados das multiplicações.

**E. Decimal para Hexadecimal:**

1. Divida o número decimal por 16.
2. Anote o resto da divisão como o dígito menos significativo do número hexadecimal (0 a 9, A a F).
    * Se o resto for maior que 9, use a letra correspondente (A para 10, B para 11, etc.).
3. Divida o quociente da divisão anterior por 16 e repita os passos 1 e 2.
4. Continue dividindo por 16 e anotando os restos até o quociente se tornar 0.
5. Leia os restos da divisão na ordem inversa, do último para o primeiro. Essa é a representação hexadecimal do número decimal.

**F. Hexadecimal para Decimal:**

1. Cada dígito na representação hexadecimal tem um peso equivalente a uma potência de 16 (começando em 16^0 para o dígito menos significativo).
2. Multiplique cada dígito pelo seu peso correspondente (A = 10, B = 11, etc.).
3. Some os resultados das multiplicações.


Estas são apenas algumas técnicas básicas de conversão. Existem outras abordagens e tabelas de conversão que podem ser utilizadas para facilitar o processo.
