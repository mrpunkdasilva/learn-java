Antes disso, definiremos o que seria um "arquivo".
A principio os sistemas operacionais abstraem essa parte física do armazenamento do usuário para que o computador seja usável, então ele mantem apenas a parte lógica -> sendo ela o `arquivo`

Como assim? Bem, o SO ele "esconde" a parte física do armazenamento( endereço de memoria, etc) e deixa apenas a parte lógica ou melhor "visual" que é o arquivo.

Os arquivos, tal parte lógica, é mapeada em **dispositivos físicos** (HD, SSD, etc) tais dispositivos **não são voláteis** (Veja mais em: [05 - Types of Memory](05%20-%20Types%20of%20Memory.md))

Já que se forem voláteis eles (os arquivos) se perderiam e o sentido de ter um computador para guardar dados não faria sentido.

Ou seja, **um arquivo é uma coleção de informações que possuem um nome** e para um usuário ele tende a ser a menor alocação (espaço) no armazenamento (memoria) secundário.

Assim, os dados só podem ser gravados no disco (armazenamento secundário) através de um arquivo
- Apenas pare e pense, **tudo em seu computador é um arquivo**, tirando as pastas (visualmente não são arquivos)


## Tipos de arquivos
Em geral os arquivos são representados de duas formas:
- **programas** -> (nas formas de fonte e objeto)
	- **executável** ou fonte -> sequencia de seções códigos executáveis que o *loader* do sistema entende e carrega na memoria principal para executar
	- **objeto** -> blocos de bytes que o *linker* do sistema consegue entender
- **dados** -> é a coleção de dados que pode ser tanto:
	- numérico => (só numero)
	- alfanumérico => (numero + texto)
	- binário (=> 0, 1)

Arquivos podem ser livres como um arquivo texto simples ou mesmo formatado rigidamente como um código de algum programa.

> Um arquivo é uma sequencia de bits, bytes ou linhas (registros), sendo seu significado definido pelo seu criador e pelo usuário

## Um pouco mais
Os arquivos possuem uma estrutura definida, que depende especificamente de qual o tipo do arquivo:
- **Se for de texto** -> uma sequencia de caracteres em linhas
- **Se for arquivo-fonte** (arquivo executável) -> ele terá instruções, sub-rotinas, funções voltadas para a execução de alguma instrução executável

> Existem diversos tipos, logo, então existem diversas estruturas

