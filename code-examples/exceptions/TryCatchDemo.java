public class TryCatchDemo {
    // Try-catch básico
    public void basicTryCatch() {
        try {
            riskyOperation();
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    // Try-catch-finally
    public void tryCatchFinally() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("data.txt");
            // Processar arquivo
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    // Multi-catch
    public void multiCatch() {
        try {
            // Operações arriscadas
            riskyOperation();
            fileOperation();
            networkOperation();
        } catch (IOException | SQLException e) {
            System.err.println("IO or SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Generic error: " + e.getMessage());
        }
    }

    // Try com recursos (exemplo antigo, para comparação)
    public void oldResourceHandling() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("test.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}