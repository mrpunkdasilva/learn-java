# Docker Básico

```ascii
DOCKER ESSENTIALS
├── Conceitos
├── Instalação
├── Comandos Básicos
├── Docker Compose
└── Best Practices
```

## Fundamentos

### Conceitos Básicos
```ascii
DOCKER COMPONENTS
├── Images
├── Containers
├── Volumes
├── Networks
└── Registry
```

### Instalação
```bash
# Linux (Ubuntu)
curl -fsSL https://get.docker.com | sh

# Windows/Mac
# Baixar Docker Desktop do site oficial
```

## Comandos Essenciais

### Gerenciamento de Containers
```bash
# Executar container
docker run hello-world
docker run -d -p 8080:80 nginx

# Listar containers
docker ps
docker ps -a

# Operações
docker start container_id
docker stop container_id
docker restart container_id
docker rm container_id
```

### Imagens
```bash
# Listar imagens
docker images

# Pull de imagem
docker pull ubuntu:latest

# Remover imagem
docker rmi imagem_id

# Build de imagem
docker build -t app:1.0 .
```

## Dockerfile

### Estrutura Básica
```dockerfile
# Base image
FROM openjdk:17-jdk-slim

# Metadados
LABEL maintainer="netrunner@corp.net"

# Diretório de trabalho
WORKDIR /app

# Copiar arquivos
COPY target/*.jar app.jar

# Porta
EXPOSE 8080

# Comando de execução
CMD ["java", "-jar", "app.jar"]
```

## Docker Compose

### docker-compose.yml
```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - DB_HOST=db
    depends_on:
      - db
  
  db:
    image: postgres:13
    environment:
      - POSTGRES_PASSWORD=secret
```

### Comandos Compose
```bash
# Iniciar serviços
docker-compose up -d

# Parar serviços
docker-compose down

# Logs
docker-compose logs
```

## Redes

### Network Commands
```bash
# Criar rede
docker network create mynet

# Listar redes
docker network ls

# Conectar container
docker network connect mynet container_id
```

## Volumes

### Volume Management
```bash
# Criar volume
docker volume create mydata

# Listar volumes
docker volume ls

# Usar volume
docker run -v mydata:/data nginx
```

## Troubleshooting

### Problemas Comuns
```bash
# Verificar logs
docker logs container_id

# Inspecionar container
docker inspect container_id

# Entrar no container
docker exec -it container_id bash
```

## Segurança

### Best Practices
```ascii
SECURITY CHECKLIST
├── Usar imagens oficiais
├── Manter containers atualizados
├── Limitar recursos
├── Usar usuários não-root
└── Escanear vulnerabilidades
```

## Monitoramento

### Ferramentas
```ascii
MONITORING TOOLS
├── Docker Stats
├── Prometheus
├── Grafana
└── cAdvisor
```

## Próximos Passos

### Aprofundamento
- Orquestração com Kubernetes
- CI/CD com Docker
- Docker Swarm
- Microserviços

[Setup Cloud](cloud-setup.md){.next-step}

---

> "Containers são como cápsulas de dados na Matrix - isolados, portáteis e prontos para deployment."