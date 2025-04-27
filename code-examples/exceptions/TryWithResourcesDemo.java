public class TryWithResourcesDemo {
    // Exemplo básico de try-with-resources
    public void readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Múltiplos recursos
    public void copyFile(String source, String destination) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    // Recurso personalizado
    public class CustomResource implements AutoCloseable {
        private final String name;
        
        public CustomResource(String name) {
            this.name = name;
            System.out.println("Resource " + name + " opened");
        }

        public void doSomething() {
            System.out.println("Resource " + name + " doing something");
        }

        @Override
        public void close() {
            System.out.println("Resource " + name + " closed");
        }
    }

    // Exemplo com recurso personalizado
    public void useCustomResource() {
        try (
            CustomResource resource1 = new CustomResource("R1");
            CustomResource resource2 = new CustomResource("R2")
        ) {
            resource1.doSomething();
            resource2.doSomething();
        } catch (Exception e) {
            System.err.println("Error using resources: " + e.getMessage());
        }
    }

    // Exemplo com supressão de exceções
    public void demonstrateSuppression() {
        try (
            AutoCloseable resource = new AutoCloseable() {
                @Override
                public void close() throws Exception {
                    throw new IOException("Error closing resource");
                }
            }
        ) {
            throw new RuntimeException("Original exception");
        } catch (Exception e) {
            System.err.println("Main exception: " + e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable t : suppressed) {
                System.err.println("Suppressed: " + t.getMessage());
            }
        }
    }
}