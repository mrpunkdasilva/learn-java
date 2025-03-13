# Exercícios Práticos Resolvidos

### **1.1. Quais são as três principais finalidades de um sistema operacional?**
1. **Gerenciamento de recursos**: Controlar e alocar hardware (CPU, memória, dispositivos de E/S) para programas.
2. **Facilitar a execução de programas**: Fornecer um ambiente para que os programas sejam executados de forma eficiente.
3. **Proteger o sistema**: Garantir que programas e usuários não interfiram uns com os outros ou com o sistema.

---

### **1.2. Quais são as principais diferenças entre os sistemas operacionais para computadores mainframe e computadores pessoais?**
- **Mainframe**:
  - Focado em alta confiabilidade, disponibilidade e processamento de grandes volumes de dados.
  - Suporta milhares de usuários simultaneamente.
  - Exemplos: IBM z/OS, Linux on IBM Z.
- **Computadores pessoais**:
  - Focado em interatividade e usabilidade para um único usuário.
  - Suporta aplicações como navegadores, editores de texto e jogos.
  - Exemplos: Windows, macOS, Linux.

---

### **1.3. Relacione as quatro etapas que são necessárias para executar um programa em uma máquina completamente dedicada – um computador que esteja executando apenas esse programa.**
1. **Carregar o programa na memória**: Transferir o código do programa do disco para a memória RAM.
2. **Configurar o contador de programa**: Definir o endereço inicial do programa para a CPU começar a executá-lo.
3. **Executar o programa**: A CPU executa as instruções do programa.
4. **Finalizar o programa**: Encerrar a execução e liberar os recursos usados.

---

### **1.4. Quando é apropriado que o sistema operacional abra mão da eficiência e “desperdice” recursos?**
- **Resposta**: Em sistemas interativos ou de tempo real, onde a experiência do usuário é prioridade (ex.: animações suaves, respostas rápidas).
- **Por que não é desperdício?**: O "desperdício" de recursos pode melhorar a usabilidade e a satisfação do usuário, o que é valioso em muitos contextos.

---

### **1.5. Qual é a principal dificuldade que um programador deverá contornar na escrita de um sistema operacional para um ambiente de tempo real?**
- **Resposta**: Garantir que o sistema atenda a prazos rígidos (deadlines) para execução de tarefas, sem atrasos.
- **Explicação**: Em sistemas de tempo real, a previsibilidade e a resposta rápida são essenciais, o que exige algoritmos de escalonamento e gerenciamento de recursos altamente otimizados.

---

### **1.6. O sistema operacional deverá incluir aplicações como navegadores Web e programas de e-mail?**
- **Argumento a favor**:
  - Facilita a usabilidade, pois o usuário já tem ferramentas essenciais instaladas.
  - Integração mais profunda com o sistema operacional.
- **Argumento contra**:
  - Aumenta o tamanho e a complexidade do sistema operacional.
  - Limita a escolha do usuário, que pode preferir outras aplicações.

---

### **1.7. Como a distinção entre o modo kernel e o modo usuário pode funcionar como uma forma rudimentar de sistema de proteção (segurança)?**
- **Resposta**: O modo kernel tem acesso total ao hardware, enquanto o modo usuário tem acesso restrito. Isso impede que programas de usuário realizem operações perigosas, como acessar diretamente o hardware ou modificar áreas críticas do sistema.

---

### **1.8. Quais das seguintes instruções deverão ser privilegiadas?**
- **Privilegiadas**:
  - a. Definir o valor do temporizador.
  - c. Apagar a memória.
  - e. Desativar interrupções.
  - f. Modificar entradas na tabela de status de dispositivo.
  - g. Passar do modo usuário para o modo kernel.
  - h. Acessar dispositivo de E/S.
- **Não privilegiadas**:
  - b. Ler o valor do relógio.
  - d. Emitir uma instrução de trap.

---

### **1.9. Duas dificuldades de proteger o sistema operacional em uma partição de memória imutável**
1. **Falta de flexibilidade**: Dificulta atualizações e correções no sistema operacional.
2. **Ineficiência**: Pode limitar o uso de técnicas avançadas de gerenciamento de memória, como memória virtual.

---

### **1.10. Dois usos possíveis para múltiplos modos de operação em CPUs**
1. **Virtualização**: Um modo adicional para executar máquinas virtuais.
2. **Segurança**: Modos intermediários para controle de acesso a recursos específicos.

---

### **1.11. Como temporizadores poderiam ser usados para calcular a hora atual?**
- **Resposta**: Um temporizador pode ser configurado para gerar interrupções em intervalos regulares (ex.: 1 segundo). Cada interrupção incrementa um contador que representa a hora atual.
- **Explicação**: O sistema operacional usa o contador para manter o relógio do sistema atualizado.

---

### **1.12. A Internet é uma LAN ou uma WAN?**
- **Resposta**: A Internet é uma **WAN (Wide Area Network)**, pois conecta redes e dispositivos em escala global, ao contrário de uma LAN (Local Area Network), que é limitada a uma área geográfica pequena, como uma casa ou escritório.
