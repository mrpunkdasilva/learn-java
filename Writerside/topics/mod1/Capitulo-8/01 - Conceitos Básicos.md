# Conceitos Básicos

## Memoria Principal

A memoria, sendo ela uma parte essencial para os sistemas computadorizados.
Sendo que a essência mais básica de uma memoria é ser formada por uma grande seguem cia de **words** e **bytes** , cada uma das partes com seu próprio endereço. 
A **CPU pega as instruções da memoria a partir do valor o contador do programa**.

Tais instruções podem fazer com que:
- Carregamento adicional 
- Alocação em endereços específicos da memoria

Um ciclo comum de execução de instrução, seria:
- **Pega** uma instrução da memoria
- **Decodifica** a instrução e faz os operandos serem buscados na memoria
- Depois de **executar**  a instrução **sobre** os operandos 
- Resultado é **guardado** de volta na memoria

![](CicloComumDeExecucaoDeInstrucaoNaMemoria.drawio%20(1).svg)

> A memoria, ou melhor, a unidade de memoria **vê apenas um fluxo de memoria** e não como são gerados pelo contador de programas, etc


## Hardware básico 

A **memoria principal** e os **registradores embutidos** no proprio processador são as **unicas unidades de armazenamento ligadas diretamente a CPU**, ou seja, somente essas unidades (memorias) conseguem ter acesso diretamente a CPU.

Algumas instruções pegam o **endereço de memoria** como argumentos, mas elas não podem acessar **endereços de disco**. Assim os dados que serão usados pelas instruções em execução, **precisam estar em um dos dispositivos**: memoria principal ou registradores embutidos no processador eles **estando ligados diretamente com a CPU**.

Portanto, caso um dado não esteja lá na memoria, **eles precisaram ser movidos para ela antes da CPU possa fazer algo** com eles.

Registradores internos da CPU **são acessiveis normalmente**  por um **ciclo de clock (rélogio)** da CPU.
Maioria das CPUs podem **decodificar e executar as instruções na velocidade de uma ou mais clock tick**.
Para a **memoria principal** isso não acontece já que nela a comunicação (acesso) é **feito pelo barramento de memoria**.
O acesso à memoria pode exigir varios ciclos de relogio (clocks) da CPU para completar.

Assim o **processador** **precisa adiar** (stall ou adiar) suas **operações** já que **ele não tem os dados** necessarios para completar a **instrução** que está **sendo executada**. Logo, essa situação se escala em um nível intolerável, pois a memoria acaba **sendo usada com muita frequência**. 

Para tal a solução é criar **uma memoria de acesso rápido** que fique **entre o processador e a memoria principal**  esse buffer **seria o intermediário** entre esses dois componentes -> este buffer é chamado de **[[08 - Caching]]**

Além da questão da velocidade devemos levar em consideração a questão de proteção, ou seja, proteger o sistema operacional tanto de programas do usuário como programas do usuário de outros programas. 

O que pode ser um problema já que devemos mantar alguns princípios de segurança como confiabilidade. Essa proteção é feita e precisa ser assim pelo hardware, assim temos mais "segurança"
 já que o hardware é o mais baixo nível que conseguimos manipular.

### Garantindo segurança
Primeiro temos que separar um espaço na memoria  (um endereço fisico) para cada processo. Assim podemos atribuir um intervalo legal (possível) de endereços físicos na memoria que podem ser acessados pelo processo. 

Com isso vamos precisar de duas medidas, o começo (base) e o fim (limite) do intervalo de memoria que podem ser acessados:
- Base -> contem o valor do menor endereço físico da memoria 
- Limite -> contem o valor do maior endereço físico 

> Essas "coisas" => base e limite possuem nome eles são  registradores, estes recebem nomes específicos que são bem óbvios: **registrador de base** e **registrador de limite**




---

[00 - Intro Gerencia de Memoria](00%20-%20Intro%20Gerencia%20de%20Memoria.md) <- Anterior | Próximo -> [02 - Associação de Endereços](02 - Associação de endereços)