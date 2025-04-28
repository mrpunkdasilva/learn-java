package com.netrunner.patterns;

// Interface de produtos abstratos para componentes de interface de usuário
interface UIComponent {
    void render();
    void handleInput();
}

// Produtos concretos - Botões
interface CyberButton extends UIComponent {
    void click();
}

class NeonButton implements CyberButton {
    @Override
    public void render() {
        System.out.println("Renderizando botão com efeito neon");
    }

    @Override
    public void handleInput() {
        System.out.println("Processando input do botão neon");
    }

    @Override
    public void click() {
        System.out.println("Click com efeito de pulso neon");
    }
}

class HologramButton implements CyberButton {
    @Override
    public void render() {
        System.out.println("Projetando botão holográfico");
    }

    @Override
    public void handleInput() {
        System.out.println("Detectando interação holográfica");
    }

    @Override
    public void click() {
        System.out.println("Ativação holográfica com feedback tátil");
    }
}

// Produtos concretos - Painéis
interface CyberPanel extends UIComponent {
    void displayInfo(String info);
}

class NeonPanel implements CyberPanel {
    @Override
    public void render() {
        System.out.println("Renderizando painel com bordas neon");
    }

    @Override
    public void handleInput() {
        System.out.println("Processando gestos no painel neon");
    }

    @Override
    public void displayInfo(String info) {
        System.out.println("Exibindo '" + info + "' com efeito neon pulsante");
    }
}

class HologramPanel implements CyberPanel {
    @Override
    public void render() {
        System.out.println("Projetando painel holográfico no ar");
    }

    @Override
    public void handleInput() {
        System.out.println("Detectando gestos 3D no holograma");
    }

    @Override
    public void displayInfo(String info) {
        System.out.println("Projetando '" + info + "' em 3D");
    }
}

// Abstract Factory
interface CyberUIFactory {
    CyberButton createButton();
    CyberPanel createPanel();
}

// Concrete Factories
class NeonUIFactory implements CyberUIFactory {
    @Override
    public CyberButton createButton() {
        return new NeonButton();
    }

    @Override
    public CyberPanel createPanel() {
        return new NeonPanel();
    }
}

class HologramUIFactory implements CyberUIFactory {
    @Override
    public CyberButton createButton() {
        return new HologramButton();
    }

    @Override
    public CyberPanel createPanel() {
        return new HologramPanel();
    }
}

// Client class
class CyberInterface {
    private final CyberButton button;
    private final CyberPanel panel;

    public CyberInterface(CyberUIFactory factory) {
        this.button = factory.createButton();
        this.panel = factory.createPanel();
    }

    public void render() {
        button.render();
        panel.render();
    }

    public void simulateInteraction() {
        button.click();
        panel.displayInfo("SISTEMA ATIVO");
        button.handleInput();
        panel.handleInput();
    }
}

// Demonstração do padrão
public class AbstractFactoryExample {
    public static void main(String[] args) {
        System.out.println("=== Interface Neon ===");
        CyberUIFactory neonFactory = new NeonUIFactory();
        CyberInterface neonInterface = new CyberInterface(neonFactory);
        neonInterface.render();
        neonInterface.simulateInteraction();

        System.out.println("\n=== Interface Holográfica ===");
        CyberUIFactory hologramFactory = new HologramUIFactory();
        CyberInterface hologramInterface = new CyberInterface(hologramFactory);
        hologramInterface.render();
        hologramInterface.simulateInteraction();
    }
}