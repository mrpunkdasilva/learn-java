
# Estrutura do Sistema de Arquivos

Os sistemas de arquivos **dizem ao kernel do armazenamento** secundário **como será tradado os arquivos no disco**.

Possuindo **duas características principais**:
1. **Alterar o disco no mesmo local** => pode-se **ler e alterar determinado bloco** do disco e **coloca-lo de volta no mesmo lugar**
	- Já que não se pode falar diretamente com a CPU e nem ela alterar diretamente parte do disco então: 
		- É feito o intermédio pela memoria RAM que vai alocar o arquivo para ela e 
		- Assim a CPU pode alterar e 
		- Então a CPU realoca o arquivo para o mesmo local, com o estado (o conteúdo) modificado

2. **O disco pode acessar diretamente `n` blocos do sistema** => ou seja, o sistema de arquivos do disco é basicamente **onisciente e onipotente** 
	- Já que ele pode acessar o bloco do disco estando tanto no bloco Z quando no bloco A (*esses nomes são penas ilustrativos*)
	- Para esse **acesso** podem existir algumas **maneiras** tanto **aleatória** quanto **sequencial**
	- Para acontecer essa **leitura e escrita o disco é necessário o movimento da cabeça do disco** - a parte que fica a agulha do disco magnetico (HD) 
		- Além de **esperar a rotação do disco**.

## Questão da eficiência

Tudo isso levanta a questão da eficiencia tanto na leitura e escrita, ou seja, **as transferências** de E/S memoria e disco **são feitas por bloco** => cada um desses blocos possuem um ou mais setores.

> Os setores **podem variar de tamanho**, podendo ter: *32 bytes à 4.096 bytes*.

Podemos dizer então que o **Sistema de Arquivos**, **garante** uma **busca**, **recuperação** e **armazenamento** de arquivos **de modo eficiente**. 


## Problemas

Sistemas de arquivos, são como *rosas*, são belas, mas possuem espinhos e alguns desses **problemas** para o **sistema de arquivos** ao serem **implementados** num **projeto** (na horar de montar um PC, pessoal que mexe com essas coisas). Tais problemas, **são bem diferentes**.

1. **Definir a interface do sistema para o usuário** => essa parte é vital, já que é como o sistema de arquivo vai funcionar para o usuário
	- Definir um **arquivo e seus atributos**
	- Quais serão as **operações permitidas**
	- Estrutura de **diretórios**, para a organização dos arquivos
	
2. **Definir como ele irá funcionar** => ou seja, essa parte dita como o sistema vai funcionar *por de baixo dos panos*, de modo que o usuario não vai ver e nem interagir, mas sem ela não funcionaria ou só não seria eficiente.
	- **Algoritmos** -> são as **instruções** tanto para fazer as buscas como os de recuperação, ou seja, tudo é feito por causa dos algoritmos
	- **Estruturas de Dados** -> a forma como os arquivos lógicos serão **organizados para serem mapeados e alterados** nos dispositivos físicos, ou seja, no armazenamento (memoria) secundaria;

## Um sistema cebola

O sistema de arquivos é basicamente montado em **niveis ou melhor camadas**. De modo que os niveis usam os recursos dos niveis mais baixos para serem usados nos niveis mais altos
- Ou seja, as **camadas mais  externas utilizam as camadas mais internas**, mas o contrario não acontece

### Niveis 

#### Nivel mais baixo
-  **Nivel mais baixo** => o controle de E/S, ou seja, **os dispositivos de E/S** que são: 
	- **Os drivers de dispositivos** -> eles são o que vai ligar um dispositivo no outro.
	- **Tratadores de interrupção** -> como os nomes dizem é o que vai fazer algo caso aconteça uma interrupção do sistema
	
Usados para **transferir informações** (dados) do **dispositivo de disco a memoria principal**.
Sendo que um driver de dispositivo -> pode ser considerado um tradutor:
- Tal que funcionaria assim:
```
# Tradução de um driver de dispositivo:

Entrada -> Sáida
   |         |
   |         |
Escrita    Convertida em
em alto    Instruções especificas -> ou seja, é jogada em código de maquina
 nivel     do hardware
```

- Essas instruções  são levadas ao **controlador do hardware** que **faz a ligação do dispositivo de E/S para o resto do sistema**.
- O driver **escreve padrões de bits específicos** e em **lugares especiais** na memoria do **controlador de E/S**, de modo que são guardadas **informações** de **onde ele deve atuar e quais serão as suas ações**

#### Sistema de arquivos básico
- **Sistema de arquivos básico** => responsável por emitir comandos genéricos 
	- Tais comandos são para para o driver de dispositivo apropriado (para aquela função necessária), como **escrever blocos físicos** no disco **ou** então **ler esses blocos** no disco
	- Cada **bloco físico possui um identificador** que é o **endereço numérico** no disco -> algo como: Unidade 1, Cilindro 02, Trilha 007, Setor 4002
	- **Essa camada** além disso, **faz o gerenciamento** dos **buffers** no disco e dos **caches** que são diversos blocos do sistema de arquivos de **diretórios e dados**
		- Um bloco no **buffer** é alocado antes mesmo da **transferência** de **um bloco** de disco 
		- Caso, o **buffer** estiver cheio então ele vai precisar:
			- **Buscar** mais memoria de buffer, ou
			- **Liberar** memoria no buffer 
	- **Caches**, são usadas para **armazenar metadados do sistema de arquivos** que são **usados com frequência**

#### Modulo de organização de arquivos
- O **módulo de organização de arquivos** => é aquele **onisciente**
	- Sabe de todos os arquivos, blocos lógicos e blocos físicos
	- Assim, como ele sabe o: 
		- Tipo de alocação de arquivo utilizado
		- Local do arquivo
	- O módulo de armazenamento pode traduzir:
		- Os **blocos lógicos** -> em **endereços físicos**
	- **Para** que o **sistema de arquivos básicos** **consiga** **transferir** o arquivo
	- Os **blocos lógicos** de **cada arquivo** são **numerados em 0 (ou 1) até N**
	- Os blocos lógicos (que contem os arquivos) não combinam com os números lógicos
		- Então é preciso traduzir os dois para localizar os blocos