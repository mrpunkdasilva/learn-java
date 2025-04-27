# Animação de Caracteres

## Sistema de Animação

A animação dos caracteres no Matrix Code envolve:

1. **Seleção de Caracteres**
2. **Transições**
3. **Timing**

## Conjunto de Caracteres

```java
public class CharacterSet {
    private static final String KATAKANA = 
        "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃ";
    private static final String NUMBERS = 
        "0123456789";
    private static final String SYMBOLS = 
        ".:*+-=><";

    public static char getRandomChar() {
        String allChars = KATAKANA + NUMBERS + SYMBOLS;
        int index = (int)(Math.random() * allChars.length());
        return allChars.charAt(index);
    }
}
```

## Sistema de Transição

```java
public class CharacterTransition {
    private char currentChar;
    private int frameCount;
    private static final int FRAMES_PER_CHANGE = 3;

    public void update() {
        frameCount++;
        if (frameCount >= FRAMES_PER_CHANGE) {
            currentChar = CharacterSet.getRandomChar();
            frameCount = 0;
        }
    }

    public char getCurrentChar() {
        return currentChar;
    }
}
```

## Controle de Timing

```java
public class AnimationTimer {
    private long lastUpdate;
    private final long frameDelay;

    public AnimationTimer(int fps) {
        this.frameDelay = 1000 / fps;
        this.lastUpdate = System.currentTimeMillis();
    }

    public boolean shouldUpdate() {
        long current = System.currentTimeMillis();
        if (current - lastUpdate >= frameDelay) {
            lastUpdate = current;
            return true;
        }
        return false;
    }
}
```

## Efeitos Especiais

### Fade Effect
```java
public class FadeEffect {
    private static final char[] FADE_CHARS = 
        {' ', '.', ':', '|', '=', '@'};

    public char getFadeChar(float intensity) {
        int index = (int)(intensity * (FADE_CHARS.length - 1));
        return FADE_CHARS[Math.min(index, FADE_CHARS.length - 1)];
    }
}
```

## Otimização

- Uso de buffer duplo
- Atualização seletiva
- Cache de caracteres

## Próximos Passos

- [Efeitos de Cor](color-effects.md)
- [Retornar aos Fundamentos](matrix-basics.md)

---

> "A animação é a alma do código. Faça-o dançar, e ele ganhará vida."