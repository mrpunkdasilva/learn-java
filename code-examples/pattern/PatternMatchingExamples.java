public class PatternMatchingExamples {
    public void demonstrateInstanceOf(Object obj) {
        // Traditional instanceof
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.toUpperCase());
        }

        // Pattern matching instanceof (Java 16+)
        if (obj instanceof String str) {
            System.out.println(str.toUpperCase());
        }
    }

    public void demonstrateSwitchPatternMatching(Object obj) {
        // Switch pattern matching (Preview feature)
        String result = switch (obj) {
            case String s -> "String de tamanho: " + s.length();
            case Integer i -> "Número: " + i;
            case Long l -> "Long: " + l;
            case null -> "Valor nulo";
            default -> "Outro tipo";
        };
    }

    public record Point(int x, int y) {}
    public record Rectangle(Point upperLeft, Point lowerRight) {}

    public void demonstrateRecordPatterns(Object obj) {
        // Record pattern matching (Preview feature)
        if (obj instanceof Rectangle(Point(int x1, int y1), Point(int x2, int y2))) {
            int width = x2 - x1;
            int height = y2 - y1;
            System.out.println("Área: " + (width * height));
        }
    }

    public void demonstrateGuardedPatterns(Object obj) {
        // Pattern matching with guards
        if (obj instanceof String s && s.length() > 5) {
            System.out.println("String longa: " + s);
        }

        if (obj instanceof Integer n && n > 0) {
            System.out.println("Número positivo: " + n);
        }
    }
}