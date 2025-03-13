# Dispositivos de E/S
Os dispositivos de entrada e saída são os responsáveis por fazer essa integração da máquina com o humano, para que se possa tanto inserir dados quanto receber esses dados processados.
Possuindo as seguintes funções:
- Receber e enviar informações para o meio.
- Converter as informações recebidas e enviadas para possuírem um formato inteligível para o computador e para o usuário.

Exemplos: teclado, mouse, HD, SSD, etc.

---

## Classificação dos Dispositivos
### Entrada
Eles fornecem os dados, ou seja, um teclado é um dispositivo de entrada.

### Saída
Eles exibem os dados, ou seja, um monitor é um dispositivo de saída.

### Entrada e Saída
Eles realizam tanto a entrada quanto a saída de dados, uma impressora se enquadra nessa categoria, já que ela recebe o que se quer imprimir e gera a saída do material impresso.

---

## Comunicação
Os dispositivos de E/S precisam se comunicar com a CPU, e para isso existem algumas tecnologias de comunicação.

### Serial
- Envio de dados bit a bit.
```
 Gabinete
-----            --------------
| CPU |----------| Controlador | 
------           | ----------- |         ---------
                 |    Buffer   |--------| Teclado |
                  -------------          --------- 
```
- O controlador também pode ser chamado de `driver`.
- Buffer: é a área que vai armazenar temporariamente e fazer a sincronização de velocidade.

#### USB
Uma das formas de fazer a comunicação de dispositivos é o Universal Serial Bus (USB), possuindo alguns tipos, como:
- Micro USB: mais lento e comum em carregadores.
- USB-A: usado de forma muito comum para conectar laptops, desktops, etc.
- USB-C: rápido, carrega e pode-se usar os dois lados para carregar, por exemplo.
- USB-B: usado em impressoras.

#### Bluetooth
É uma forma de conexão feita por ondas de rádio, simples, sem fio e rápida.

#### Wi-Fi
Conexão feita por sinais sem fio.

---

## Gerenciamento dos Dispositivos
Existem algumas formas de gerenciamento:
- Polling: antiga forma de gerenciamento, em que a CPU fica constantemente consultando os dispositivos de E/S para verificar se estão prontos ou precisando de atenção.
- Interrupção: a CPU fica ouvindo um dispositivo e, quando este terminar sua tarefa, ela será interrompida para processar a solicitação.
- DMA (Acesso Direto à Memória): permite o acesso direto à memória principal para transferir dados, sem a intervenção da CPU em cada processo.

