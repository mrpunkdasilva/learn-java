# Instalação do JDK

```ascii
JDK INSTALLATION
├── SDKMAN! Setup
├── JDK Selection
├── Environment Config
└── Validation
```

## SDKMAN!

### Instalação do SDKMAN!
```bash
# Download e instalação
curl -s "https://get.sdkman.io" | bash

# Recarregar shell
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Verificar instalação
sdk version
```

### Comandos Básicos
```ascii
SDKMAN COMMANDS
├── sdk list java     # Listar versões
├── sdk install java  # Instalar JDK
├── sdk use java     # Usar versão
└── sdk default java # Definir padrão
```

## Instalação do JDK

### Escolha da Distribuição
```ascii
JDK OPTIONS
├── Oracle JDK
│   └── Licença comercial
├── OpenJDK
│   └── Open source
├── Amazon Corretto
│   └── AWS optimized
├── Eclipse Temurin
│   └── AdoptOpenJDK successor
└── GraalVM
    └── Native compilation
```

### Instalação via SDKMAN!
```bash
# Listar versões disponíveis
sdk list java

# Instalar JDK LTS
sdk install java 17.0.8-tem

# Definir como padrão
sdk default java 17.0.8-tem
```

## Configuração do Ambiente

### Variáveis de Ambiente
```bash
# Verificar JAVA_HOME
echo $JAVA_HOME

# Verificar PATH
echo $PATH | grep java
```

### Configuração Manual (se necessário)
```bash
# Para Bash/Zsh
echo "export JAVA_HOME=$HOME/.sdkman/candidates/java/current" >> ~/.bashrc
echo "export PATH=\$JAVA_HOME/bin:\$PATH" >> ~/.bashrc

# Para Fish
set -Ux JAVA_HOME $HOME/.sdkman/candidates/java/current
set -Ux PATH $JAVA_HOME/bin $PATH
```

## Verificação da Instalação

### Testes Básicos
```bash
# Verificar versão Java
java --version

# Verificar compilador
javac --version

# Testar compilação
echo 'public class Test { public static void main(String[] args) { System.out.println("Hello, NetRunner!"); } }' > Test.java
javac Test.java
java Test
```

## Multi-versão

### Gerenciamento de Versões
```bash
# Instalar múltiplas versões
sdk install java 11.0.20-tem
sdk install java 17.0.8-tem
sdk install java 21-tem

# Alternar entre versões
sdk use java 11.0.20-tem  # Temporário
sdk default java 17.0.8-tem  # Permanente
```

### Configuração por Projeto
```bash
# Criar arquivo de configuração
echo "java=17.0.8-tem" > .sdkmanrc

# Ativar ambiente do projeto
sdk env
```

## Troubleshooting

### Problemas Comuns
1. **SDKMAN! não instala**
   - Verificar curl instalado
   - Verificar permissões
   - Verificar conexão

2. **JDK não encontrado**
   - Recarregar terminal
   - Verificar PATH
   - Verificar JAVA_HOME

3. **Conflitos de versão**
   - Usar `sdk flush`
   - Remover versão: `sdk rm java`
   - Reinstalar SDKMAN!

## Próximos Passos

### Configuração IDE
- Configurar Project SDK
- Importar projetos
- Configurar build tools

[Configurar IDE](ide-setup.md){.next-step}

---

> "A base de todo netrunner é um JDK bem configurado. Escolha suas armas com sabedoria."