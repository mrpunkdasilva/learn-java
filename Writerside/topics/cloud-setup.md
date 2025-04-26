# Setup Cloud

```ascii
CLOUD SETUP
├── Providers
├── CLI Tools
├── Authentication
└── Basic Services
```

## Cloud Providers

### Principais Provedores
```ascii
CLOUD OPTIONS
├── AWS
├── Azure
├── Google Cloud
└── Oracle Cloud
```

## CLI Setup

### AWS CLI
```bash
# Instalar AWS CLI
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install

# Configurar
aws configure
```

### Azure CLI
```bash
# Instalar Azure CLI
curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash

# Login
az login
```

### Google Cloud SDK
```bash
# Instalar Google Cloud SDK
curl https://sdk.cloud.google.com | bash

# Inicializar
gcloud init
```

## Autenticação

### Credenciais
```ascii
AUTH METHODS
├── Access Keys
├── Service Accounts
├── IAM Roles
└── MFA
```

### Configuração
```bash
# AWS Credentials
aws configure set aws_access_key_id YOUR_KEY
aws configure set aws_secret_access_key YOUR_SECRET

# GCloud Auth
gcloud auth login
gcloud config set project YOUR_PROJECT
```

## Serviços Básicos

### Storage
```ascii
STORAGE SERVICES
├── AWS S3
├── Azure Blob
└── Google Cloud Storage
```

### Compute
```ascii
COMPUTE SERVICES
├── EC2/VM
├── Container Services
└── Serverless
```

## Networking

### VPC Setup
```ascii
NETWORK CONFIG
├── VPC/VNET
├── Subnets
├── Security Groups
└── Load Balancers
```

## Monitoramento

### Ferramentas Cloud
```ascii
MONITORING
├── CloudWatch
├── Azure Monitor
└── Cloud Monitoring
```

## Segurança

### Best Practices
```ascii
SECURITY CHECKLIST
├── MFA Ativado
├── Least Privilege
├── Encryption
└── Logging
```

## Cost Management

### Controle de Custos
```ascii
COST CONTROL
├── Budgets
├── Alerts
├── Resource Tags
└── Cost Explorer
```

## Próximos Passos

### Aprofundamento
- Infrastructure as Code
- Cloud Native Development
- Serverless Architecture
- Multi-Cloud Strategy

[Começar com Java](java-basics.md){.next-step}

---

> "A nuvem é a nova fronteira da Matrix - um território vasto de recursos virtualizados prontos para serem explorados."