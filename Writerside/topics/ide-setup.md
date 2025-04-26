# Configuração da IDE

```ascii
IDE SETUP
├── IntelliJ IDEA
├── Eclipse
├── VS Code
└── NetBeans
```

## IntelliJ IDEA

### Instalação
```ascii
INTELLIJ VARIANTS
├── Community Edition
│   └── Open Source
└── Ultimate Edition
    └── Trial/Licensed
```

```bash
# Linux (snap)
sudo snap install intellij-idea-community --classic

# macOS (brew)
brew install --cask intellij-idea-ce

# Windows
winget install JetBrains.IntelliJ.IDEA.Community
```

### Plugins Essenciais
```ascii
CORE PLUGINS
├── Java Development
├── Git Integration
├── Maven/Gradle
└── Docker
```

### Configuração Inicial
```ascii
INITIAL SETUP
├── Project SDK
├── Code Style
├── File Templates
└── Live Templates
```

## Visual Studio Code

### Instalação
```bash
# Linux
sudo snap install code --classic

# macOS
brew install --cask visual-studio-code

# Windows
winget install Microsoft.VisualStudioCode
```

### Extensões Java
```ascii
EXTENSIONS
├── Extension Pack for Java
├── Spring Boot Extension Pack
├── Java Test Runner
└── Debugger for Java
```

### Configurações Recomendadas
```json
{
    "java.home": "/path/to/jdk",
    "java.format.settings.url": "eclipse-formatter.xml",
    "java.completion.importOrder": [
        "java",
        "javax",
        "com",
        "org"
    ]
}
```

## Eclipse

### Instalação
```ascii
ECLIPSE PACKAGES
├── Eclipse IDE for Java
├── Eclipse IDE for Enterprise
└── Eclipse IDE for Web
```

```bash
# Linux
sudo snap install eclipse --classic

# macOS
brew install --cask eclipse-java

# Windows
winget install Eclipse.Java
```

### Plugins Recomendados
```ascii
ECLIPSE PLUGINS
├── EGit
├── Spring Tools
├── CodeMix
└── Darkest Dark Theme
```

## Configurações Avançadas

### Personalização
```ascii
CUSTOMIZATION
├── Theme Setup
├── Keymap Config
├── Code Templates
└── Live Templates
```

### Integração Git
```ascii
GIT SETUP
├── SSH Keys
├── GitHub Integration
├── GitLab Integration
└── Bitbucket Integration
```

### Debug & Profiling
```ascii
DEBUG TOOLS
├── Remote Debug
├── Memory Analyzer
├── CPU Profiler
└── Thread Dump
```

## Produtividade

### Atalhos Essenciais
```ascii
SHORTCUTS
├── Code Completion
│   ├── Ctrl+Space
│   └── Alt+Enter
├── Navigation
│   ├── Ctrl+Click
│   └── Alt+F7
├── Refactoring
│   ├── Shift+F6
│   └── Ctrl+Alt+M
└── Debug
    ├── F8
    └── F9
```

### Templates
```java
// Live Template: psvm
public static void main(String[] args) {
    
}

// Live Template: sout
System.out.println();

// Live Template: fori
for (int i = 0; i < ; i++) {
    
}
```

## Troubleshooting

### Problemas Comuns
1. **IDE não reconhece JDK**
   - Verificar JAVA_HOME
   - Reconfigurar Project SDK
   - Invalidar caches

2. **Performance lenta**
   - Aumentar heap memory
   - Desabilitar plugins
   - Limpar índices

3. **Problemas de indexação**
   - Invalidar caches
   - Reconstruir índices
   - Verificar exclusões

## Configuração do Projeto

### Estrutura Básica
```ascii
PROJECT STRUCTURE
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       └── resources/
├── pom.xml
└── .gitignore
```

### Build Tools
```ascii
BUILD CONFIG
├── Maven
│   └── pom.xml
└── Gradle
    └── build.gradle
```

## Próximos Passos

### Workflow Setup
- Configurar formatação de código
- Definir templates de projeto
- Configurar integração contínua
- Preparar ambiente de debug

[Configurar Git](git-basics.md){.next-step}

---

> "Uma IDE bem configurada é como ter um deck cyberdeck personalizado - aumenta exponencialmente sua eficiência na Matrix."