public class Calculator {
    public static void main(String[] args) {
        // Demonstração de tipos primitivos
        int num1 = 10;
        double num2 = 5.5;
        
        // Demonstração de var keyword
        var result1 = num1 + num2; // Inferência para double
        var result2 = num1 * num2; // Inferência para double
        
        // Demonstração de operadores aritméticos e type casting
        double divisionResult = (double) num1 / 3;
        int moduloResult = num1 % 3;
        
        // Demonstração de String formatting
        String output = String.format("""
            Calculadora Básica
            ------------------
            Números: %d e %.1f
            Soma: %.2f
            Multiplicação: %.2f
            Divisão: %.2f
            Resto: %d
            """, 
            num1, num2, result1, result2, divisionResult, moduloResult);
        
        // Demonstração de operadores bitwise
        int bitwiseAnd = num1 & 3;  // 10 & 3
        int bitwiseOr = num1 | 3;   // 10 | 3
        
        // Usando StringBuilder para construir a saída final
        StringBuilder builder = new StringBuilder(output);
        builder.append(String.format("Operação AND bit a bit: %d%n", bitwiseAnd));
        builder.append(String.format("Operação OR bit a bit: %d", bitwiseOr));
        
        // Exibindo resultados
        System.out.println(builder.toString());
    }
}