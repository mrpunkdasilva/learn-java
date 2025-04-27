public class BasicExceptions {
    // Demonstração de diferentes tipos de exceções
    public void demonstrateExceptions() {
        // RuntimeException (Unchecked)
        try {
            int[] array = new int[5];
            array[10] = 1; // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index error: " + e.getMessage());
        }

        // Checked Exception
        try {
            File file = new File("nonexistent.txt");
            FileReader fr = new FileReader(file); // FileNotFoundException
        } catch (FileNotFoundException e) {
            System.err.println("File error: " + e.getMessage());
        }

        // Multiple exceptions
        try {
            String str = null;
            str.length(); // NullPointerException
        } catch (NullPointerException e) {
            System.err.println("Null reference: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Generic error: " + e.getMessage());
        }
    }

    // Demonstração de throw
    public void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (age > 150) {
            throw new IllegalArgumentException("Age cannot be greater than 150");
        }
        System.out.println("Age is valid: " + age);
    }
}