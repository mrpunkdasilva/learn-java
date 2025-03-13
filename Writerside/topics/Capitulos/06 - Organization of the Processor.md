# Organização do Processador 🧠

A **CPU** é responsável pelo processamento e execução de programas que estão armazenados nela. Ela é dividida em três partes:

1. **Unidade Central** (UC);
2. **Registradores**;
3. **Unidade Lógica Aritmética** (ULA ou UAL);

Podendo ser dividida em duas partes funcionais:

- **Unidade Funcional de Controle**;
    - UC
- **Unidade Funcional de Processamento**;
    - ULA e Registradores

---
## Diagrama de Funcionamento da CPU

```
           Unidade Funcional de Processamento
  -------                -----------------        
  | ULA |                | Registradores |         
  ---|---                | (RISC e CISC) |         
     |                   -----|--------|--         
     |                        |        |           
     |                        |        |           
==== | ====================== | ====== | =================================
     |     -------------      |        |
     |-----| Barramento |-----|        |     
     |-----|  Interno   |-------|------|--|-----------|O------------|
     |     -------------        |         |           |             |
     |                          |         |           |             | 
     |                          |         |           |             |
==== | ======================== | ======= | ========= | =========== | ====
     |                          |         |      -----|------   ---------
     |                          |         |      | B.       |   | B.    |  
     |----|---------------|   --|--    ---|--    | Endereço |   | Dados |
     |    | Decodificador |---| RI |---| CI |    -----|------   ----|---- 
     |    | de Instruções |   -----    ------    REM  |         RDM |
     |----|---------------|                           |             | 
     |                                                |             |
   --|---                                      |------O------|      | 
   | UC |--------------------------------------|   Memória   O------|
   ------                                      |  Principal  |
                                               |-------------|                                      
        Unidade funcional de Controle                                          

- REM => Registro de Endereços Memória
- RDM => Registro de Dados Memória
```

## Unidade Funcional de Processamento
Todo sistema operacional possui uma única função de existência, ou seja, o porquê dele existir e a função para esses sistemas são: **entrar com dados**, **processar dados**, **saída de dados processados**, assim nasce a Unidade Funcional de Processamento.

Logo a UFP, possui algumas operações básicas:
- Operações Aritméticas 
- Álgebra Booleana
- Movimentação de Dados entre a CPU e a Memória

---
### ULA
É a parte central da CPU já que é onde as operações lógicas e aritméticas irão ser feitas.
Ela não recebe as instruções diretamente, e sim as instruções são processadas pela UC. Assim que processado, é enviado para a ULA que realiza o que se pede e retorna o resultado.

### Registradores
É o tipo de memória que é rápida e com pouco armazenamento.
Sendo que varia em sua função e quantidade de acordo com o modelo do processador.
A maioria dos processadores utilizam a arquitetura baseada em registradores de processos gerais (RISC/CISC):
- **RISC (Reduced Instructions Set Computer):**
    - Caracterizado pela **simplicidade e eficiência** nas execuções de instruções (voltado mais para dispositivos que exigem menos processamento como dispositivos móveis e laptops);

- **CISC (Complex Instructions Set Computer):**
    - Caracterizado por um conjunto de instruções mais **complexas e abrangentes** (voltado para dispositivos que exigem mais poder de processamentos como desktops e servidores);

---
## Unidade Funcional de Controle
Executa algumas funções:
- Busca de instruções a serem executadas e armazenadas em um registrador da CPU;
- Interpretar as instruções para serem enviadas à ULA 
    - Gerar sinais de controle, ao interpretar vai gerar um sinal para a ULA dizendo qual das operações devem ser executadas;

### Contador de Instruções (CI)
O Contador de Instruções é aquele que vai registrar a contagem para sequenciamento das instruções, ou seja, montar aquela fila de fichas, onde cada ficha possui um número de ordem de chamada para que se possa ter o controle das ordens de instruções.

### Registrador de Instruções (RI)
Este Registrador de Instruções possui a função de armazenar a instrução que deve ser executada pela CPU.

### Decodificador de Instruções
O **RI** irá passar uma _sequência de bits_ representando a instrução a ser executada para o **Decodificador de Instruções** que, por sua vez, irá interpretar essa sequência de bits e relacionar com a operação que deve ser feita. Em seguida, mandar essa instrução já interpretada para a **UC**, assim ela manda os sinais necessários para a ULA, por exemplo, do que deve ser feito.

- Diagrama de funcionamento RI e Decod. Instruc.
```
    ------     _____________      ______
    | UC |o----| Decod.    |o-----| RI |
    ------     | Instrução |      ------
               -------------
```


---
### RDM e REM
- RDM (Registrador de Dados em Memória): sendo o registrador que _armazena os dados que estão sendo transmitidos_ da CPU e para a Memória e vice-versa.

- REM (Registrador de Endereços de Memória): sua função é _armazenar o endereço de acesso à memória_ para que seja necessária a leitura e a escrita de dados.

> Ambos os registradores possuem registro temporário dos dados que são gravados neles.

```
    --------------
    | Barramento o-----|----------|
    |  Interno   |------|         |
    --------------      |         |
                     ---|---   ---|---
                     | RDM |   | REM |
                     -----|-   ---|---
                          |       |
                         -o-------o-
                         | Memória |
                         -----------

o => significa o fluxo de direção dos dados
```

