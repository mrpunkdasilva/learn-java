# Efeitos de Cor

## Sistema de Cores

O Matrix Code utiliza cores ANSI para criar seus efeitos visuais característicos.

## Códigos de Cor

```java
public class MatrixColors {
    // Códigos ANSI básicos
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String DIM_GREEN = "\u001B[2;32m";
    
    // Códigos RGB personalizados
    public static String rgb(int r, int g, int b) {
        return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }
}
```

## Gradiente de Cores

```java
public class ColorGradient {
    private static final int MAX_INTENSITY = 255;

    public String getGradientColor(float intensity) {
        int green = (int)(intensity * MAX_INTENSITY);
        return MatrixColors.rgb(0, green, 0);
    }
}
```

## Aplicação de Efeitos

```java
public class ColorEffects {
    private final ColorGradient gradient;
    
    public String applyDropEffect(int position, int maxLength) {
        float intensity = 1.0f - ((float)position / maxLength);
        return gradient.getGradientColor(intensity);
    }
    
    public String applyGlowEffect(char character) {
        return character == ' ' ? MatrixColors.RESET :
                                MatrixColors.BRIGHT_GREEN;
    }
}
```

## Efeitos Avançados

### Pulsação
```java
public class PulseEffect {
    private float phase = 0;
    private static final float SPEED = 0.1f;

    public String getPulseColor() {
        float intensity = (float)(Math.sin(phase) + 1) / 2;
        phase += SPEED;
        return new ColorGradient().getGradientColor(intensity);
    }
}
```

### Rastro Luminoso
```java
public class TrailEffect {
    private static final int TRAIL_LENGTH = 5;

    public String getTrailColor(int distance) {
        float intensity = 1.0f - ((float)distance / TRAIL_LENGTH);
        return intensity > 0 ? 
            new ColorGradient().getGradientColor(intensity) :
            MatrixColors.RESET;
    }
}
```

## Otimização

- Cache de cores
- Atualização seletiva
- Modo de baixo consumo

## Compatibilidade

- Verificação de suporte ANSI
- Fallback para terminais simples
- Modos alternativos

## Próximos Passos

- [Retornar aos Fundamentos](matrix-basics.md)
- [Animação de Caracteres](character-animation.md)

---

> "As cores da Matrix não são apenas visuais - são a própria essência do código digital."