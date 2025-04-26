# Git Básico

```ascii
GIT FUNDAMENTALS
├── Setup Inicial
├── Operações Básicas
├── Branching
├── Remote Operations
└── Best Practices
```

## Instalação e Setup

### Instalação
```bash
# Linux (Debian/Ubuntu)
sudo apt install git

# macOS
brew install git

# Windows
winget install Git.Git
```

### Configuração Inicial
```bash
# Identidade
git config --global user.name "Seu Nome"
git config --global user.email "seu@email.com"

# Editor padrão
git config --global core.editor "code --wait"  # VS Code
# git config --global core.editor "vim"        # Vim
# git config --global core.editor "nano"       # Nano

# Configurar branch padrão
git config --global init.defaultBranch main
```

## Operações Básicas

### Ciclo de Vida
```ascii
FILE STATUS
├── Untracked
├── Staged
├── Committed
└── Modified
```

### Comandos Essenciais
```bash
# Iniciar repositório
git init

# Status do repositório
git status

# Adicionar arquivos
git add <arquivo>      # Arquivo específico
git add .              # Todos os arquivos

# Commit
git commit -m "mensagem"
git commit -am "mensagem"  # Add + Commit

# Histórico
git log
git log --oneline
git log --graph
```

## Branches

### Operações com Branches
```bash
# Listar branches
git branch

# Criar branch
git branch feature/nova-funcionalidade

# Mudar de branch
git checkout feature/nova-funcionalidade
# ou
git switch feature/nova-funcionalidade

# Criar e mudar
git checkout -b feature/nova-funcionalidade
```

### Merge e Rebase
```bash
# Merge
git checkout main
git merge feature/nova-funcionalidade

# Rebase
git checkout feature/nova-funcionalidade
git rebase main
```

## Operações Remotas

### Configuração Remota
```bash
# Adicionar remote
git remote add origin https://github.com/user/repo.git

# Listar remotes
git remote -v

# Remover remote
git remote remove origin
```

### Sincronização
```bash
# Push
git push origin main

# Pull
git pull origin main

# Fetch
git fetch origin

# Clone
git clone https://github.com/user/repo.git
```

## Gitflow

### Estrutura de Branches
```ascii
BRANCH STRUCTURE
├── main
├── develop
├── feature/*
├── release/*
├── hotfix/*
└── bugfix/*
```

### Workflow Básico
```ascii
WORKFLOW
├── Criar feature branch
├── Desenvolver
├── Commit changes
├── Push to remote
└── Create pull request
```

## Boas Práticas

### Commits
```ascii
COMMIT PATTERNS
├── Conventional Commits
│   ├── feat: nova feature
│   ├── fix: correção
│   ├── docs: documentação
│   ├── style: formatação
│   ├── refactor: refatoração
│   ├── test: testes
│   └── chore: manutenção
└── Atomic Commits
```

### .gitignore
```bash
# Java
*.class
*.jar
target/

# IDEs
.idea/
.vscode/
*.iml

# Logs
*.log
logs/

# OS
.DS_Store
Thumbs.db
```

## Git Avançado

### Stash
```bash
# Salvar alterações
git stash

# Listar stashes
git stash list

# Aplicar stash
git stash apply
git stash pop

# Limpar stash
git stash clear
```

### Reset e Revert
```bash
# Reset
git reset --soft HEAD~1   # Mantém alterações
git reset --hard HEAD~1   # Remove alterações

# Revert
git revert HEAD          # Reverte último commit
```

## Troubleshooting

### Problemas Comuns
1. **Conflitos de Merge**
   ```bash
   # Abortar merge
   git merge --abort
   
   # Resolver manualmente
   # Editar arquivos
   git add .
   git commit
   ```

2. **Branch Errada**
   ```bash
   # Mover alterações
   git stash
   git checkout branch-correta
   git stash pop
   ```

3. **Commit Errado**
   ```bash
   # Desfazer último commit
   git reset --soft HEAD~1
   
   # Alterar mensagem
   git commit --amend
   ```

## Ferramentas Visuais

### GUI Clients
```ascii
GUI OPTIONS
├── GitKraken
├── SourceTree
├── GitHub Desktop
└── Git GUI
```

## Próximos Passos

### Aprofundamento
- Explorar Git hooks
- Configurar CI/CD
- Aprender rebase interativo
- Estudar estratégias de branching

[Essenciais do Terminal](terminal-essentials.md){.next-step}

---

> "No submundo digital, o controle de versão é sua linha do tempo pessoal - cada commit é um checkpoint que você pode revisitar."