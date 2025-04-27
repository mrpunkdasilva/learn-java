public class PluginSystem {
    private Plugin[] plugins;
    private int pluginCount;
    private static final int MAX_PLUGINS = 10;

    public PluginSystem() {
        plugins = new Plugin[MAX_PLUGINS];
        pluginCount = 0;
    }

    public void addPlugin(Plugin plugin) {
        if (pluginCount < MAX_PLUGINS) {
            plugins[pluginCount] = plugin;
            pluginCount++;
            System.out.println("Plugin " + plugin.getName() + " foi adicionado ao sistema!");
        } else {
            System.out.println("Sistema está cheio! Não é possível adicionar mais plugins.");
        }
    }

    public void enablePlugin(String name) {
        Plugin plugin = findPlugin(name);
        if (plugin != null) {
            plugin.enable();
        }
    }

    public void disablePlugin(String name) {
        Plugin plugin = findPlugin(name);
        if (plugin != null) {
            plugin.disable();
        }
    }

    public void executeCommand(String pluginName, String command) {
        Plugin plugin = findPlugin(pluginName);
        if (plugin != null) {
            plugin.executeCommand(command);
        }
    }

    public void listPlugins() {
        System.out.println("\nLista de Plugins:");
        for (int i = 0; i < pluginCount; i++) {
            Plugin plugin = plugins[i];
            String status = plugin.isEnabled() ? "Ativado" : "Desativado";
            System.out.println(plugin.getName() + " - " + status);
            
            System.out.println("Comandos disponíveis:");
            for (String cmd : plugin.getCommands()) {
                System.out.println("  - " + cmd);
            }
            System.out.println();
        }
    }

    private Plugin findPlugin(String name) {
        for (int i = 0; i < pluginCount; i++) {
            if (plugins[i].getName().equals(name)) {
                return plugins[i];
            }
        }
        System.out.println("Plugin '" + name + "' não encontrado!");
        return null;
    }
}