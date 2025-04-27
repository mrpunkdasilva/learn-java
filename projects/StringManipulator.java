public class StringManipulator {
    public static void main(String[] args) {
        // Demonstração de String como tipo de referência
        String text = "NetRunner";
        String text2 = "MATRIX";
        
        // Demonstração de métodos de String
        var lowercase = text.toLowerCase();
        var uppercase = text.toUpperCase();
        var length = text.length();
        
        // Demonstração de StringBuilder
        StringBuilder builder = new StringBuilder(text);
        var reversed = builder.reverse().toString();
        builder.reverse(); // Voltando ao original
        
        // Demonstração de concatenação
        builder.append("_").append(text2);
        var combined = builder.toString();
        
        // Demonstração de String formatting
        var output = String.format("""
            Manipulador de Strings
            --------------------
            Original: %s
            Minúsculas: %s
            Maiúsculas: %s
            Tamanho: %d
            Reverso: %s
            Combinado: %s
            """,
            text, lowercase, uppercase, 
            length, reversed, combined);
            
        // Demonstração de operadores lógicos com strings
        boolean startsWithNet = text.startsWith("Net");
        boolean endsWithRunner = text.endsWith("Runner");
        boolean containsMatrix = combined.contains("MATRIX");
        
        // Adicionando resultados das verificações
        StringBuilder finalOutput = new StringBuilder(output);
        finalOutput.append(String.format("""
            
            Verificações:
            Começa com 'Net': %b
            Termina com 'Runner': %b
            Contém 'MATRIX': %b
            """,
            startsWithNet, endsWithRunner, containsMatrix));
        
        // Exibindo resultados
        System.out.println(finalOutput.toString());
    }
}