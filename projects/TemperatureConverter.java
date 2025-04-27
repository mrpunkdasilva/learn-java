public class TemperatureConverter {
    public static void main(String[] args) {
        // Demonstração de tipos primitivos
        double celsius = 25.0;
        double fahrenheit = 77.0;
        
        // Demonstração de operadores aritméticos
        var celsiusToFahr = (celsius * 9/5) + 32;
        var fahrToCelsius = (fahrenheit - 32) * 5/9;
        
        // Demonstração de operadores lógicos
        boolean isHot = celsius > 30;
        boolean isCold = celsius < 10;
        boolean isModerate = !isHot && !isCold;
        
        // Demonstração de String formatting
        String temperatureInfo = String.format("""
            Conversor de Temperatura
            ----------------------
            Celsius: %.1f°C = %.1f°F
            Fahrenheit: %.1f°F = %.1f°C
            """,
            celsius, celsiusToFahr,
            fahrenheit, fahrToCelsius);
            
        // Usando StringBuilder para adicionar análise
        StringBuilder analysis = new StringBuilder(temperatureInfo);
        analysis.append("\nAnálise da temperatura:\n");
        analysis.append(String.format("Quente: %b%n", isHot));
        analysis.append(String.format("Frio: %b%n", isCold));
        analysis.append(String.format("Moderado: %b", isModerate));
        
        // Exibindo resultados
        System.out.println(analysis.toString());
    }
}