# Tipos de Memoria
Primiro devemos entender como é o ciclo das memorias, num computador:
```
-> ligar -> PC -> Corre na CPU -> Confere a ROM 
-> Vai na memoria secundaria para buscar o SO 
-> usa a memoria principal para carregar os programas
```

A **Memoria** é um dispositivo que vai servir para armazenar dados ou instruções para que a CPU use.
Possuindo dois tipos de memorias, **permanente** e **ão permanente**.
As memorias esão interligas e fromam o **subistema de memorias**.


## Pirâmide de Memorias 
Pode-se classificar as memorias com base em algumas propriedades.

- **Quanto mais alto**:
    - Mais caro 
    - Mais rapido
    - Baixa capacidade de armazenamento

- **Quanto mais baixo:** 
    - Mais barato
    - Menos rapido
    - Alta capacidade de armazenamento

```
              /\
             /  \
            /    \
           / Regis\
          / trador \
         /          \
        /            \ 
       /    Cache     \
      /                \
     /     Memoria      \
    /      Principal     \
   /     (RAM e ROM)      \
  /                        \
 /    Memmoria Secundaria   \
/      (HD, CD/DVD, SSD)     \
-------------------------------
```

## Registradores
O processador busca informações e instruções na memoria e armazena em seu interior o que deve ser feito.
Para tal esse local onde são armazenados é denominado como `registradore
s`.

## Cache 
O Cache sere para suprir a necessidade do processador de ter uma memoria auxiliar.
Servindo para acelerar a comunicação entre o `processador` e a `memoria princial`.
### Cache L1
Sendo a primeira a ser buscada, a memoria cache que está dentro do processador, dividida em dois campos:
- **L1d**: feito para guardar dadeos
- **L1i**: feito para guardar instruções
#### Cache L2 
Ao não encontrar o que se proucurava na L1 é feita a busca em L2.
E essaa memoria utiliza o sistema: Static Random Access Memory

Ao não se encontrar no Cache L2, ela é responsavel por chamar a memoria princial, ou seja, a DRAM (Dynamic Random Access Memory)

## Memoria Principal
Responsável por alocar informações das aplicações executadas no momento em que o PC ainda está ligado. Por isso ela precisa ficar refrescando a memoria, assim ela funciona de modo dinamico.
 A memoria princial é denominada memoria RAM. 
### Padrões de RAM  
 - DDR: este padrão tem como caracteristica a duplicação de lotes de bits por 1 ciclo de clock, ou seja, 64 bits por 1 ciclo de clock (ida e volta do CPU a Memoria)
    - Ela possui varias versões que mudam em voltagem, latencia, etc...
### Formato 
- DIMM: usadas em desktops, são mais parrudas, tudo em uma linha
- SO-DIMM: usadas em laptops, são mais acopladas e em varias linhas

### ROM
É a memoria que é apenas para leitura (Read Only Memory = ROM), escrita normalmente pelo fabricane e apenas lida depois. Os programas instalados nela são chamados de **firmwares**.

Firmwares já instalados:
- BIOS: sistema Básico de Entrada e Saida;
- POST: autoteste e verificação no momento da incialização;
- SETUP: muda as configurações já pre-definidas;

## Memoria Secundaria 
É a memoria que vai ser aquela que vai armazenar os dados em massa, ou seja, o `SO` e outros programas, assim como, outros dados e por isso ela não pode ser `vólatil`.
Essas memorias **não** são **acessadas** pelo **processador**.

> Volátil é igual a desligou o PC ela deixou de existir, igual a gigolos, acabou o dinheiro não se vê mais ninguém 
> 
> SO é o Sistema Operacional, sendo a interface entre hardware e humano e software. ele é aquele amigo cúpido

