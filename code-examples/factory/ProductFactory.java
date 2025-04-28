public interface Product {
    void doSomething();
}

public class ConcreteProductA implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product A doing something");
    }
}

public class ConcreteProductB implements Product {
    @Override
    public void doSomething() {
        System.out.println("Product B doing something");
    }
}

public class ProductFactory {
    public Product createProduct(String type) {
        return switch (type) {
            case "A" -> new ConcreteProductA();
            case "B" -> new ConcreteProductB();
            default -> throw new IllegalArgumentException("Unknown product type");
        };
    }
}