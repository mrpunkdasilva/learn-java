# Representação de Dados
Um computador realiza uma execução sistematica de instruções sobre valores, esses valores são nomeados genericamente de:  **dados**. Tais valores são códigos bínarios (0 e 1).
```
 processa
    |
    |
 instruções
    |
    |---valores
         |____ 0101
         |____ 11100
```
 
## Processo de Conversão
Para conversarmos com esses dados e o computador conversar conosco, usa-se um processo conversão de linguagens: linguagem do computador para a natural.
Sendo que:
- Alto nivel: temos as linguagens que os programadores usam para conversar com o PC
    - Linguagem natural (não se usa binario e sim simbolos que se assemelham a linguagem humana)
    - Alto nivel de abstração  
- Baixo Nivel:
    - Conversa diretamente com o computador, linguagem binaria (0 e 1)
    - Baixo nivel de abstração

## Formas de Representação 
Tais formas variavam de acordo com as escolhas de qum desenvolve e com a plataforma que usa-se.
Podendo haver variações da forma como se define o tipo de dado a ser usado:
- Fortemente Tipada: deve ser definido os tipos de dados na hoa do desenvolvimento
- Fracamente Tipada: deixa essa responsabilidade de tipagem para o compilador da linguagem

# Tipos de Dados 
Existem alguns tipos dados:
- integer: eles são numeros inteiros, representados de formas variadas dependendo da linguagem, podendoter: 8bits, 16bits, 32bits e 64bits.
- real: são numeros decimais e podem ser subdivididos em dois grupos:
    - float: menor precisão. 
    - double: maior precisão.
- caractere (char): usad para representar apenas um caractre, sendo normalmente usado aspas simples para criar o char
- cadeia de caracteres (string): são mais de um caractere entre aspas (sendo simples ou duplas)
- booleano: valore lógicos que podm ser: true (verdadeiro ou 1) ou false (falso ou 0)

## Representação da Memoria
Pode-se dizr que a memoria funciona como um vetor, ela possui indices e neles tem seus valores. Só que difrente de um vetor a memoria permite acesso direto e aleatorio dos indices e não necessita de percorrer sequencialmente.

> O sistema de gerenciamento de memoria é o programa que realiza a alocação de memoria e a coleta de lixo, logo a memoria RAM possui alocações e librações dinamicas.