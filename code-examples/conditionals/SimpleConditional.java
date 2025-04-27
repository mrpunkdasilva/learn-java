public class SimpleConditional {
    public void demonstrateIf(int score) {
        // Simple if
        if (score >= 70) {
            System.out.println("Aprovado!");
        }

        // if-else
        if (score >= 90) {
            System.out.println("Excelente!");
        } else {
            System.out.println("Continue tentando!");
        }

        // if-else-if ladder
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }

    public void demonstrateTernary(int age) {
        // Ternary operator
        String status = age >= 18 ? "Adulto" : "Menor";
        
        // Nested ternary (use with caution)
        String category = age >= 18 
            ? age >= 60 ? "Idoso" : "Adulto" 
            : "Menor";
    }
}