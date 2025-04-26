# Visão Geral das Ferramentas

```ascii
NETRUNNER TOOLKIT
├── Development
│   ├── JDK
│   ├── IDE
│   └── Build Tools
├── Version Control
│   ├── Git
│   └── GitHub/GitLab
├── Containers
│   ├── Docker
│   └── Kubernetes
└── Cloud Tools
    ├── AWS CLI
    ├── Azure CLI
    └── GCloud SDK
```

## Ferramentas Essenciais

### JDK (Java Development Kit)
```ascii
JDK DISTRIBUTIONS
├── Oracle JDK
├── OpenJDK
├── Amazon Corretto
├── Eclipse Temurin
└── GraalVM
```

#### Gerenciadores de Versão
- SDKMAN! - Gerenciamento de SDKs
- Jabba - Alternativa multiplataforma
- jEnv - Específico para Unix

### IDEs (Integrated Development Environment)
```ascii
IDE OPTIONS
├── IntelliJ IDEA
│   ├── Community Edition
│   └── Ultimate Edition
├── Eclipse
│   └── Enterprise Edition
├── VS Code
│   └── Java Extensions
└── NetBeans
```

#### Recursos Principais
- Debugging avançado
- Integração com ferramentas
- Refatoração inteligente
- Suporte a frameworks

### Build Tools
```ascii
BUILD SYSTEMS
├── Maven
│   ├── Dependency Management
│   └── Lifecycle Management
├── Gradle
│   ├── Groovy DSL
│   └── Kotlin DSL
└── Ant (Legacy)
```

## Ferramentas de Controle de Versão

### Git
```ascii
GIT ESSENTIALS
├── Controle de versão
├── Branching
├── Merging
└── Colaboração
```

### Interfaces Git
```ascii
GIT GUI TOOLS
├── GitKraken
├── SourceTree
├── GitHub Desktop
└── IDE Integration
```

## Ferramentas de Container

### Docker
```ascii
DOCKER STACK
├── Docker Engine
├── Docker Compose
├── Docker Hub
└── Docker Desktop
```

### Container Registry
```ascii
REGISTRY OPTIONS
├── Docker Hub
├── GitHub Packages
├── AWS ECR
└── Azure Container Registry
```

## Ferramentas Cloud

### CLI Tools
```ascii
CLOUD TOOLS
├── AWS CLI
├── Azure CLI
├── Google Cloud SDK
└── Heroku CLI
```

### Cloud IDEs
```ascii
CLOUD DEVELOPMENT
├── GitHub Codespaces
├── GitPod
├── Cloud9
└── Eclipse Che
```

## Ferramentas de Produtividade

### Terminal
```ascii
TERMINAL SETUP
├── Windows Terminal
├── iTerm2 (macOS)
├── Terminator (Linux)
└── Shell
    ├── Bash
    ├── Zsh
    └── Fish
```

### Extensões Recomendadas

#### VS Code
```ascii
VS CODE EXTENSIONS
├── Java Extension Pack
├── Spring Boot Tools
├── Debugger for Java
└── Test Runner
```

#### IntelliJ IDEA
```ascii
INTELLIJ PLUGINS
├── Lombok
├── SonarLint
├── GitToolBox
└── Rainbow Brackets
```

## Ferramentas de Teste

### Testing Framework
```ascii
TEST TOOLS
├── JUnit
├── TestNG
├── Mockito
└── AssertJ
```

### Análise de Código
```ascii
CODE QUALITY
├── SonarQube
├── CheckStyle
├── PMD
└── SpotBugs
```

## Ferramentas de Documentação

### Documentation
```ascii
DOCUMENTATION
├── JavaDoc
├── Swagger/OpenAPI
├── AsciiDoc
└── Markdown
```

## Setup Inicial

### Checklist de Instalação
- [ ] JDK via SDKMAN!
- [ ] IDE principal
- [ ] Git
- [ ] Docker
- [ ] Cloud CLI necessária
- [ ] Terminal configurado

### Configuração Recomendada
```bash
# Instalar JDK
sdk install java

# Configurar Git
git config --global user.name "Seu Nome"
git config --global user.email "seu@email.com"

# Verificar Docker
docker --version
```

## Manutenção

### Atualizações Regulares
```ascii
UPDATE ROUTINE
├── JDK patches
├── IDE updates
├── Docker images
└── Dependencies
```

### Backup de Configurações
```ascii
BACKUP ESSENTIALS
├── IDE settings
├── Git config
├── Docker config
└── Terminal preferences
```

## Troubleshooting

### Problemas Comuns
1. **Conflitos de Versão Java**
   - Usar SDKMAN! para gerenciar versões
   - Verificar JAVA_HOME
   - Limpar caches

2. **Problemas IDE**
   - Limpar caches
   - Atualizar índices
   - Reinstalar plugins

3. **Issues Docker**
   - Verificar serviço
   - Limpar volumes
   - Reset configurações

[Começar Instalação JDK](jdk-installation.md){.next-step}

---

> "Um netrunner é tão bom quanto suas ferramentas. Escolha-as sabiamente."