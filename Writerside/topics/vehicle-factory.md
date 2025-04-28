# Vehicle Factory Pattern

## Visão Geral

O Vehicle Factory é uma implementação do Abstract Factory Pattern que demonstra a criação de diferentes tipos de veículos e seus componentes.

```ascii
VEHICLE FACTORY
├── Abstract Factory
├── Concrete Factories
│   ├── SportsCar Factory
│   ├── SUV Factory
│   └── Truck Factory
├── Abstract Products
│   ├── Engine
│   ├── Body
│   └── Interior
└── Concrete Products
    ├── Sports Components
    ├── SUV Components
    └── Truck Components
```

## Implementação

### 1. Interfaces Base

```java
// Componentes abstratos
public interface Engine {
    void start();
    int getHorsepower();
}

public interface Body {
    String getDesign();
    double getAerodynamics();
}

public interface Interior {
    int getSeatingCapacity();
    String getUpholsteryType();
}

// Fábrica abstrata
public interface VehicleFactory {
    Engine createEngine();
    Body createBody();
    Interior createInterior();
}
```

### 2. Implementação Sports Car

```java
// Componentes concretos do Sports Car
public class TurboEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Iniciando motor turbo de alta performance");
    }
    
    @Override
    public int getHorsepower() {
        return 450;
    }
}

public class AerodynamicBody implements Body {
    @Override
    public String getDesign() {
        return "Design aerodinâmico esportivo";
    }
    
    @Override
    public double getAerodynamics() {
        return 0.28; // Coeficiente de arrasto
    }
}

public class SportInterior implements Interior {
    @Override
    public int getSeatingCapacity() {
        return 2;
    }
    
    @Override
    public String getUpholsteryType() {
        return "Couro esportivo com costuras contrastantes";
    }
}

// Fábrica concreta de Sports Car
public class SportsCarFactory implements VehicleFactory {
    @Override
    public Engine createEngine() {
        return new TurboEngine();
    }
    
    @Override
    public Body createBody() {
        return new AerodynamicBody();
    }
    
    @Override
    public Interior createInterior() {
        return new SportInterior();
    }
}
```

### 3. Implementação SUV

```java
public class SUVFactory implements VehicleFactory {
    @Override
    public Engine createEngine() {
        return new PowerfulEngine();
    }
    
    @Override
    public Body createBody() {
        return new RobustBody();
    }
    
    @Override
    public Interior createInterior() {
        return new LuxuryInterior();
    }
}

public class PowerfulEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Iniciando motor V6 com torque elevado");
    }
    
    @Override
    public int getHorsepower() {
        return 300;
    }
}

// Outras implementações de componentes SUV...
```

## Uso do Factory

### 1. Cliente Base

```java
public class VehicleAssembler {
    private final VehicleFactory factory;
    
    public VehicleAssembler(VehicleFactory factory) {
        this.factory = factory;
    }
    
    public Vehicle assembleVehicle() {
        Engine engine = factory.createEngine();
        Body body = factory.createBody();
        Interior interior = factory.createInterior();
        
        return new Vehicle(engine, body, interior);
    }
}
```

### 2. Exemplo de Uso

```java
public class Demo {
    public static void main(String[] args) {
        // Criando um carro esportivo
        VehicleFactory sportsFactory = new SportsCarFactory();
        VehicleAssembler sportsAssembler = new VehicleAssembler(sportsFactory);
        Vehicle sportsCar = sportsAssembler.assembleVehicle();
        
        // Criando um SUV
        VehicleFactory suvFactory = new SUVFactory();
        VehicleAssembler suvAssembler = new VehicleAssembler(suvFactory);
        Vehicle suv = suvAssembler.assembleVehicle();
        
        // Testando os veículos
        testVehicle(sportsCar);
        testVehicle(suv);
    }
    
    private static void testVehicle(Vehicle vehicle) {
        System.out.println("Testando veículo:");
        vehicle.getEngine().start();
        System.out.println("Potência: " + vehicle.getEngine().getHorsepower() + " hp");
        System.out.println("Design: " + vehicle.getBody().getDesign());
        System.out.println("Capacidade: " + vehicle.getInterior().getSeatingCapacity() + " pessoas");
        System.out.println();
    }
}
```

## Extensões Possíveis

1. **Sistema de Configuração**
```java
public class VehicleConfigurator {
    private final VehicleFactory factory;
    private final Map<String, Object> options;
    
    public VehicleConfigurator(VehicleFactory factory) {
        this.factory = factory;
        this.options = new HashMap<>();
    }
    
    public void setOption(String key, Object value) {
        options.put(key, value);
    }
    
    public Vehicle configure() {
        Vehicle vehicle = new VehicleAssembler(factory).assembleVehicle();
        applyOptions(vehicle);
        return vehicle;
    }
    
    private void applyOptions(Vehicle vehicle) {
        // Aplicar opções personalizadas
    }
}
```

## Melhores Práticas

1. **Coesão de Componentes**
   - Mantenha componentes relacionados na mesma família
   - Garanta compatibilidade entre componentes
   - Evite dependências entre famílias diferentes

2. **Extensibilidade**
   - Projete para facilitar adição de novos tipos de veículos
   - Mantenha interfaces consistentes
   - Use composição sobre herança

3. **Validação**
   - Verifique compatibilidade de componentes
   - Valide configurações
   - Implemente testes unitários

## Anti-Patterns a Evitar

1. **Mistura de Responsabilidades**
   - Não misture lógica de negócio nas fábricas
   - Evite acoplamento entre famílias diferentes
   - Mantenha separação clara de concerns

2. **Complexidade Desnecessária**
   - Não crie hierarquias muito profundas
   - Evite excesso de customização
   - Mantenha o código simples e direto

## Exercício Prático

Implemente um sistema de fábrica de veículos elétricos:

1. Crie componentes específicos para veículos elétricos
2. Implemente uma nova fábrica concreta
3. Adicione funcionalidades específicas de veículos elétricos
4. Integre com o sistema existente

```java
public interface ElectricVehicleFactory extends VehicleFactory {
    Battery createBattery();
    ElectricMotor createMotor();
    ChargingSystem createChargingSystem();
}

public class ElectricSportsCarFactory implements ElectricVehicleFactory {
    // Implementação...
}
```

## Próximos Passos

1. Explore integração com outros padrões
2. Implemente persistência de configurações
3. Adicione validações de segurança
4. Desenvolva interface de usuário
5. Implemente testes automatizados