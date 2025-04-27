public class Main {
    public static void main(String[] args) {
        // Criar sistema de plugins
        PluginSystem system = new PluginSystem();

        // Criar alguns plugins
        Plugin calculadora = new Plugin("Calculadora", 
            new String[]{"somar", "subtrair", "multiplicar"});
        
        Plugin notas = new Plugin("Notas", 
            new String[]{"criar", "listar", "apagar"});
        
        Plugin tempo = new Plugin("Tempo", 
            new String[]{"hora", "data", "cronometro"});

        // Adicionar plugins ao sistema
        system.addPlugin(calculadora);
        system.addPlugin(notas);
        system.addPlugin(tempo);

        // Listar plugins inicialmente
        system.listPlugins();

        // Ativar alguns plugins
        system.enablePlugin("Calculadora");
        system.enablePlugin("Tempo");

        // Tentar executar comandos
        System.out.println("\nTestando comandos:");
        system.executeCommand("Calculadora", "somar");
        system.executeCommand("Notas", "criar");  // Não vai funcionar pois está desativado
        system.executeCommand("Tempo", "hora");
        system.executeCommand("Calculadora", "dividir");  // Comando não existe

        // Listar plugins novamente para ver mudanças
        system.listPlugins();
    }
}