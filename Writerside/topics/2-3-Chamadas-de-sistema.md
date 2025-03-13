# 2.3 Chamadas de sistema

As **chamadas de sistema** são a interface entre os programas e os serviços oferecidos pelo sistema operacional. Elas permitem que programas solicitem operações como leitura/escrita de arquivos, gerenciamento de memória e comunicação com dispositivos. Aqui está um resumo organizado:

---

### **1. O que são Chamadas de Sistema?**
- **Definição**: São rotinas que permitem que programas solicitem serviços do sistema operacional.
- **Implementação**: Escritas em linguagens como C/C++ ou assembly (para tarefas de baixo nível).
- **Exemplo**: Um programa que lê dados de um arquivo e os copia para outro usa várias chamadas de sistema:
  - Solicitar nomes dos arquivos (E/S).
  - Abrir arquivos.
  - Ler e escrever dados.
  - Tratar erros (arquivo inexistente, falta de espaço no disco, etc.).
  - Fechar arquivos e finalizar o programa.

---

### **2. Como Funcionam?**
- **Sequência de Chamadas**:
  1. Solicitar nomes dos arquivos (E/S interativa ou via GUI).
  2. Abrir arquivo de entrada e criar arquivo de saída.
  3. Ler dados do arquivo de entrada e escrever no arquivo de saída.
  4. Tratar erros durante a leitura/escrita.
  5. Fechar arquivos e finalizar o programa.
- **Exemplo de Chamadas**:
  - `open()`: Abrir um arquivo.
  - `read()`: Ler dados de um arquivo.
  - `write()`: Escrever dados em um arquivo.
  - `close()`: Fechar um arquivo.

---

### **3. APIs e Chamadas de Sistema**
- **API (Interface de Programação de Aplicação)**:
  - Conjunto de funções que simplificam o uso de chamadas de sistema.
  - Exemplos: API Win32 (Windows), API POSIX (UNIX/Linux/Mac), API Java.
  - **Vantagens**:
    - Portabilidade: Programas podem rodar em sistemas com a mesma API.
    - Facilidade: APIs são mais simples de usar do que chamadas de sistema diretas.
- **Relacionamento**:
  - Funções da API (ex.: `CreateProcess()` no Windows) chamam funções do sistema operacional (ex.: `NTCreateProcess()`).
  - O sistema operacional executa a operação e retorna o resultado.

---

### **4. Passagem de Parâmetros**
- **Métodos**:
  1. **Registradores**: Parâmetros são passados diretamente nos registradores da CPU.
  2. **Bloco/Tabela**: Parâmetros são armazenados em memória, e o endereço do bloco é passado em um registrador.
  3. **Pilha**: Parâmetros são empilhados (push) e desempilhados (pop) pela CPU.
- **Exemplo**: No Linux, parâmetros são passados como uma tabela na memória.

---

### **5. Chamadas de Sistema em Java**
- **Java Native Interface (JNI)**:
  - Permite que métodos Java chamem funções nativas escritas em C/C++.
  - Essas funções podem invocar chamadas de sistema específicas do sistema operacional.
  - **Limitação**: Programas que usam JNI perdem portabilidade entre plataformas.

---

### **6. Exemplo Prático**
- **API Java**:
  - Método `write()` da classe `java.io.OutputStream`:
    - Escreve dados em um arquivo ou conexão de rede.
    - Parâmetros: `byte[] b` (dados), `int off` (offset), `int len` (número de bytes).
    - Lança `IOException` em caso de erro.

#### Diagrama

```
                     [Chamadas de Sistema]  
                               
       --------------------------------------------------------------  
        |                      |                                   |  
    [O que são?]          [Como Funcionam?]                 [APIs e Chamadas]  
        |                      |                                    |  
 - Interface entre programas   - Sequência de operações:  - APIs simplificam chamadas  
   e sistema operacional       1. Solicitar arquivos     - Exemplos: Win32, POSIX, Java  
 - Implementadas em C/C++/     2. Abrir/ler/escrever     - Funções API chamam funções do SO  
   Assembly                    3. Tratar erros           - Exemplo: CreateProcess() → NTCreateProcess()  
                               4. Fechar arquivos        - Vantagens: Portabilidade, facilidade  

        ------------------------------------------------  
        |                      |                      |  
    [Passagem de Parâmetros]  [Java e Chamadas]      [Exemplo Prático]  
        |                           |                        |  
 - Métodos:                   - Java Native Interface  - API Java: write()  
   1. Registradores             (JNI) permite chamadas  - Parâmetros: byte[] b, int off, int len  
   2. Bloco/Tabela              de funções nativas      - Lança IOException em erros  
   3. Pilha                     (C/C++) para chamadas  
                                de sistema  
                              - Perde portabilidade  
```