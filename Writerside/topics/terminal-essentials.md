# Essenciais do Terminal

```ascii
TERMINAL MASTERY
├── Básico
├── Navegação
├── Manipulação
├── Processos
└── Customização
```

## Comandos Fundamentais

### Navegação
```bash
# Listar arquivos
ls
ls -la

# Mudar diretório
cd path/to/dir
cd ..
cd ~

# Mostrar diretório atual
pwd
```

### Manipulação de Arquivos
```bash
# Criar
touch arquivo.txt
mkdir pasta

# Copiar
cp origem destino
cp -r pasta1 pasta2

# Mover/Renomear
mv origem destino

# Remover
rm arquivo.txt
rm -r pasta
```

### Visualização
```bash
# Ver conteúdo
cat arquivo.txt
less arquivo.txt
head arquivo.txt
tail arquivo.txt

# Buscar
grep "texto" arquivo.txt
find . -name "*.java"
```

## Permissões

### Gerenciamento
```bash
# Visualizar
ls -l

# Modificar
chmod +x script.sh
chmod 755 arquivo

# Mudar proprietário
chown usuario:grupo arquivo
```

## Processos

### Gerenciamento
```bash
# Listar processos
ps aux
top

# Background
comando &
bg
fg

# Terminar processo
kill PID
killall processo
```

## Redirecionamento

### Input/Output
```bash
# Redirecionamento
comando > output.txt
comando >> output.txt
comando < input.txt

# Pipes
comando1 | comando2
```

## Ambiente

### Variáveis
```bash
# Exibir
echo $PATH
env

# Definir
export JAVA_HOME=/path/to/java
```

## Customização

### Shell RC
```bash
# .bashrc ou .zshrc
alias ll='ls -la'
alias gs='git status'

# Path
export PATH=$PATH:/novo/caminho
```

## Atalhos

### Keyboard Shortcuts
```ascii
SHORTCUTS
├── Ctrl + C  (Cancelar)
├── Ctrl + L  (Limpar)
├── Ctrl + R  (Buscar histórico)
├── Ctrl + A  (Início da linha)
└── Ctrl + E  (Fim da linha)
```

## Scripts

### Shell Scripts
```bash
#!/bin/bash

# Exemplo básico
echo "Iniciando script..."
for i in {1..5}; do
    echo "Iteração $i"
done
```

## Ferramentas Avançadas

### Power Tools
```ascii
POWER TOOLS
├── tmux    (Terminal Multiplexer)
├── vim     (Editor)
├── htop    (Process Viewer)
└── fzf     (Fuzzy Finder)
```

## Troubleshooting

### Debug
```bash
# Debug modo
set -x

# Verificar status
echo $?

# Ver logs
tail -f /var/log/syslog
```

## Próximos Passos

### Aprofundamento
- Shell scripting avançado
- Automação com cron
- Terminal multiplexing
- Customização avançada

[Básico do Docker](docker-basics.md){.next-step}

---

> "O terminal é sua interface direta com a Matrix - domine-o, e você controlará o sistema."