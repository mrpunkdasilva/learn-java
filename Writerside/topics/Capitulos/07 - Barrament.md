# Barramentos
Barramentos são as **interconexões** dos componentes computacionais.

## Tipos de Barramentos
São divididos em três categorias:
- Estrutura
    - Dados 
    - Endereço
    - Controle
- Hierarquia 
    - Local
    - Sistema
    - Expansão

---
### Estrutura 
É formado por três tipos seguintes de Barreamentos:

```
    CPU   MP  E/S
     |    |    |
--------------------  Barramnto Dados
     |    |    | 
-------------------- Barramento Endereços
     |    |    |
-------------------- Barramento Controle
```

---
#### Barramento de Dados
Esse barramento _interliga o RDM (Registrador de Dados em Memória) com a memória principal_, para a **transferência de instruções** ou **dados a serem executados**.

Sendo um barramento bidirecional:
    - Já que pode tanto ir da _CPU à Memória_, assim realizando uma **operação de escrita**;
    - E também consegue ir da _Memória à CPU_, assim realizando uma **operação de leitura**.

A **largura do barramento** está diretamente ligada ao **desempenho da máquina**, já que quanto mais envio de dados (bits) maior será a velocidade e poder de processamento, tal que, por consequência, o desempenho irá aumentar. Os primeiros PCs continham apenas 8 bits de largura do seu barramento, hoje temos algo em torno ou maior que 128 bits.

---
#### Barramento de Endereços
Feito para interligar o _REM (Registrador de Endereços de Memória) com a Memória Principal_ que irá **fazer a transferência de bits que vão representar endereços de memória** das **instruções ou dados a serem executados**.
Tem seu sentido **unidirecional**, já que somente a CPU aciona a memória principal para fazer operações de leitura e escrita.

---
#### Barramento de Controle
Irá _interligar a UC com os outros componentes_.
Sendo **bidirecional**, pois consegue enviar sinais de controle para a Memória e receber dela sinais do tipo *wait* (espere), para que possa terminar a execução da tarefa para começar outra.

Assim, os **barramentos** compartilham os dados por vias que são físicas, por meio de fios de cobre, e conectam todos os componentes.

---
### Hierarquia de Barramentos
A Hierarquia está ligada à **velocidade** de tráfego desses barramentos.

#### Barramento Local ou Interno
É o barramento mais rápido, já que está dentro da área da CPU e funcionando no mesmo tempo do relógio do processador, ou seja, está na mesma velocidade de clock do processador.

#### Barramento Sistema
Tem por finalidade fazer a conexão entre o barramento local com os outros componentes do sistema, como por exemplo: memória principal, cache L2, E/S. Ele faz uso do _chipset norte_ da placa-mãe.

Um Circuito Integrado (**chipset**) cuida de fazer a integração desse barramento deste modo:

```
      |----------|
      | Placa de |   |-----------|      |------| 
      |  Vídeo   |   | Memória|  |      | CPU  |
      |---|------|   | Principal |      |--|---|
          |          |-----|-----|         | 
          |                | Barramento    |
          |                | de Memória    |
          |           |----|--|            |                         
          |-----------| Ponte |------------|
       Barramento     | Norte |   Barramento Externo
         AGPU         |-------|
```

---
#### Barramento de Expansão (ou E/S)
Sendo o barramento que **interliga os dispositivos de E/S com os outros componentes** do computador. Tal integração ocorre por meio do chipset (circuito integrado) chamado de: **ponte sul**.

```
            
                    
                    Barramento 
           |------|    PCI     |-------|     
           | Pont |------------- Algum |
           | Sul  |            |  E/S  |
           |--|---|            |-------| 
              |  
              | Barramento ATA ou IDE
              |
            |-|------|
            | Disco  |
            | Rigido |
            |--------|
```

> 💡 Em Discos Rigidos os dois tipos **ATA** e **IDE** podem ser integrados irá variar do tipo de memoria escolhida.
> -  **ATA**
> ![[Pasted image 20240910104916.png]]
> - IDE
> ![[Pasted image 20240910105001.png]]

---
## Slots
Os slots nada mais são que as entradas que os barramentos possuem (as boquinhas que têm na placa-mãe para conectar os fios).  
Os slots variam de acordo com o modelo da placa-mãe.

![[Pasted image 20240910105028.png]]
