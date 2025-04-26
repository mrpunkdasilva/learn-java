# Configuração do Sistema Operacional

```ascii
>> Iniciando diagnóstico do sistema...
>> Verificando compatibilidade...
>> Ajustando configurações base...
>> Sistema preparado para desenvolvimento...
```

## Requisitos por Sistema

### Windows
```ascii
WINDOWS SETUP
├── Windows 10/11
├── PowerShell 5.1+
├── Windows Terminal
└── WSL2 (recomendado)
```

### macOS
```ascii
MACOS SETUP
├── Catalina (10.15)+
├── Terminal/iTerm2
├── Homebrew
└── Command Line Tools
```

### Linux
```ascii
LINUX SETUP
├── Kernel 5.0+
├── Terminal
├── Package Manager
└── Build Tools
```

## Configuração do Windows

### 1. Habilitar WSL2
```powershell
# Habilitar WSL
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart

# Habilitar Virtualização
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart

# Definir WSL2 como padrão
wsl --set-default-version 2
```

### 2. Windows Terminal
```ascii
TERMINAL FEATURES
├── Multi-tabs
├── Temas personalizados
├── Split panes
└── Integração WSL
```

### 3. Variáveis de Ambiente
```powershell
# Adicionar ao Path
[Environment]::SetEnvironmentVariable(
    "Path",
    [Environment]::GetEnvironmentVariable("Path", "Machine") + ";C:\your\path",
    "Machine"
)
```

## Configuração do macOS

### 1. Homebrew
```bash
# Instalar Homebrew
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Verificar instalação
brew doctor
```

### 2. Command Line Tools
```bash
# Instalar Command Line Tools
xcode-select --install

# Verificar instalação
xcode-select -p
```

### 3. Terminal Enhancement
```bash
# Instalar iTerm2
brew install --cask iterm2

# Instalar Oh My Zsh
sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

## Configuração do Linux

### 1. Pacotes Essenciais
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install build-essential curl wget git

# Fedora
sudo dnf groupinstall "Development Tools"
sudo dnf install curl wget git
```

### 2. Terminal Setup
```bash
# Instalar e configurar ZSH
sudo apt install zsh
chsh -s $(which zsh)

# Instalar Oh My Zsh
sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

## Configurações Comuns

### 1. Git Global
```bash
# Configuração básica
git config --global user.name "Seu Nome"
git config --global user.email "seu@email.com"

# Editor padrão
git config --global core.editor "code --wait"
```

### 2. SSH Keys
```bash
# Gerar nova chave SSH
ssh-keygen -t ed25519 -C "seu@email.com"

# Iniciar ssh-agent
eval "$(ssh-agent -s)"

# Adicionar chave
ssh-add ~/.ssh/id_ed25519
```

## Personalização

### Terminal Theme
```json
{
    "colorScheme": "Cyberpunk",
    "fontFace": "Cascadia Code",
    "fontSize": 12,
    "useAcrylic": true,
    "acrylicOpacity": 0.8
}
```

### Aliases Úteis
```bash
# Git aliases
alias gs='git status'
alias ga='git add'
alias gc='git commit'
alias gp='git push'

# Navigation
alias ll='ls -la'
alias ..='cd ..'
alias ...='cd ../..'
```

## Ambientes de Desenvolvimento Isolados

### SDKMAN! com Docker
```dockerfile
FROM ubuntu:22.04

# Instalar dependências
RUN apt-get update && apt-get install -y \
    curl \
    zip \
    unzip

# Instalar SDKMAN!
RUN curl -s "https://get.sdkman.io" | bash
ENV SDKMAN_DIR="/root/.sdkman"

# Configurar ambiente
COPY .sdkmanrc /app/.sdkmanrc
WORKDIR /app

# Instalar SDKs
RUN bash -c "source $SDKMAN_DIR/bin/sdkman-init.sh && \
    sdk env install"
```

### Gerenciamento de Versões por Projeto
```ascii
PROJECT STRUCTURE
├── .sdkmanrc        # Versões do projeto
├── .java-version    # Alternativa para Java
└── docker-compose.yml
```

### Exemplo de docker-compose.yml
```yaml
version: '3.8'
services:
  java-dev:
    build: .
    volumes:
      - .:/app
    environment:
      - SDKMAN_DIR=/root/.sdkman
```

### Scripts de Automação
```bash
#!/bin/bash
# setup-dev.sh

# Verificar SDKMAN!
if ! command -v sdk &> /dev/null; then
    echo "Instalando SDKMAN!..."
    curl -s "https://get.sdkman.io" | bash
fi

# Carregar SDKMAN!
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Instalar versões do projeto
if [ -f .sdkmanrc ]; then
    echo "Configurando ambiente do projeto..."
    sdk env install
fi
```

### Integração com IDEs
```ascii
IDE INTEGRATION
├── IntelliJ IDEA
│   └── Project SDK
├── Eclipse
│   └── Installed JREs
└── VS Code
    └── Java Runtime
```

### Verificação de Ambiente
```bash
# Verificar todas as versões instaladas
sdk current

# Listar candidatos instalados
sdk list

# Verificar ambiente do projeto
sdk env
```

## Verificação

### Checklist Final
- [ ] Sistema atualizado
- [ ] Terminal configurado
- [ ] Git instalado
- [ ] SSH configurado
- [ ] Aliases definidos

### Teste de Ambiente
```bash
# Verificar versões
java -version
git --version
node --version

# Testar SSH
ssh -T git@github.com
```

## Troubleshooting

### Problemas Comuns
1. **WSL não inicia**
   - Verificar virtualização no BIOS
   - Reinstalar WSL
   - Atualizar Windows

2. **Homebrew falha**
   - Verificar permissões
   - Atualizar macOS
   - Reinstalar Xcode CLI

3. **Linux packages quebrados**
   - Limpar cache
   - Atualizar repositórios
   - Verificar dependências

[Explorar Ferramentas](tools-overview.md){.next-step}

---

> "Configure seu sistema como um verdadeiro netrunner - cada detalhe importa na Matrix."