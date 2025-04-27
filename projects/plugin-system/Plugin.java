public class Plugin {
    private String name;
    private boolean isEnabled;
    private String[] commands;

    public Plugin(String name, String[] commands) {
        this.name = name;
        this.isEnabled = false;
        this.commands = commands;
    }

    public void enable() {
        isEnabled = true;
        System.out.println("Plugin " + name + " foi ativado!");
    }

    public void disable() {
        isEnabled = false;
        System.out.println("Plugin " + name + " foi desativado!");
    }

    public void executeCommand(String command) {
        if (!isEnabled) {
            System.out.println("Plugin " + name + " está desativado!");
            return;
        }

        boolean commandFound = false;
        for (String cmd : commands) {
            if (cmd.equals(command)) {
                commandFound = true;
                System.out.println("Executando comando '" + command + "' do plugin " + name);
                break;
            }
        }

        if (!commandFound) {
            System.out.println("Comando '" + command + "' não encontrado no plugin " + name);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public String[] getCommands() {
        return commands;
    }
}