# Tabela Verdade

## O que seria Tabela Verdade?
Tabela Verdade a ´forma como podemos obter valores de **expressões booleanas** de todas as possiveis combinações.

> Expressões Booleanas são aquelas que possuem apenas dois valores lógicos: verdadeiro (true) ou falso (false).

Ajudando a construção de circuitos e na verificação de preposições lógicas.

## Lógica Proposicional
É a linguagem que usamos para manipular `proposições`. 

### Proposiçõe  
São afirmações que podem ser vvaloradas em dois únicos valores: `verdadeiro` ou `falso`. Pode-se tipar as proposiçõe de dois tipos: `simples` e `compostas`;
Elas possuem uma regra de  reepresentação, que é: devem usar letras minusculas
> Normalmente se usa: `p`, `q`, `r`, etc
- Exemplo: p = Sou o Douglas; q = Você não é o Douglas

#### Simples 
É quando existe uma única proposição. 
- Exemplo: Está chovendo (verdadeiro ou Falso)

#### Compostas
É quando se tem mais de uma proposição, ligadas por `conectivos lógicos`.
- Eexemplo: Está chovendo **ou** está nublado (com ouso do `ou` se liga duas proposições e assim se estabelece determinada regra do conectivo que está sendo usado)


### Conectivos Lógicos 
Ssão particulas usadas para **combinar** e **modificar** proposições e assim criar **expressoões booleanas**

 
#### Alguns Conectivos
 - **Negação**  (¬ ou ~): ele nega a sentença, loo o que é verdadeiro fica falsoe o que ´é falsose torna verdadeiro.
    - Exemplo: p = Gustavo é antinteração;  ~p = Gustavo não é antinteração

| p | q | ~p | ~q  |
| --|---|----|-----|
| V | F | F  |  V  |
| F | V | V  |  F  |
| V | V | F  |  F  |
| F | F | V  |  V  |
    

- **Conjuntivo** (^): esse conectivo diz que para ser verdadeiro as duas devem ser verdadeiras
    - Exemplo: p = verdadeiro; q = verdadeiro; p ^ q = Verdairo

| p | q |  p ^ q  |
|---|---|---------|
| v | f |    f    |
| f | v |    f    |
| v | v |    v    |
| f | f |    f    |


- **Disjunção** (v): é ao conectivo em que apenas uma precisa ser verdadeira para que a expressão resulte em verdadeiro.
    - Exemplo: p = verdadeiro; q = falso; p v q = verdadeiro

| p | q |  p v q  |
|---|---|---------|
| v | f |    v    |
| f | v |    v    |
| v | v |    v    |
| f | f |    f    |


- **Condicional (se...então)** (->): é o conectivoem quse baseia em que para sser verdadeiro, a condição `p` devera verdadeiro para que a proposição `q` seja verdadeira.
    - Exemplo: p = verdadeiro; q = verdadeiro; p -> q = verdadeiro

| p | q |  p -> q |
|---|---|---------|
| v | f |    f    |
| f | v |    v    |
| v | v |    v    |
| f | f |    v    |


- **Bicondicional (se somente se)** (<->):é o conectivo em que a condição estabelecida equivale para as duas proposições, ou seja, será verdadeiro se as duas forem atentidas.
    - Exemplo: p = Vou gastar; q = tiver dinheiro; p <-> q = verdadeiro = Vou gasta, se somente se, tiver dinheiro

| p | q | p <-> q |
|---|---|---------|
| v | f |    f    |
| f | v |    f    |
| v | v |    v    |
| f | f |    v    |


#### Tabela de Conectivos
| Conectivo       | Valor |
| --------------- | --------------- |
|  ~  |  Será verdadeiro se for falso e falso se for verdadeiro |
|  ^  | Será verdadeiro se ambas forem verdadeiras |
|  v  | Se uma ou as duas forem verdadeiras então resulta em verdadeiro |
|  -> | Se a primira for verdadeira e a segunda for falsa então resulta em falso,senão é verdadeiro |
| <-> | Só será verdadeiro se as duas tiverem o mesmo valor, senão é falso |

