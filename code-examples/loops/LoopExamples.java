public class LoopExamples {
    public void demonstrateForLoops() {
        // Basic for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Contador: " + i);
        }

        // Enhanced for loop (for-each)
        String[] frutas = {"Maçã", "Banana", "Laranja"};
        for (String fruta : frutas) {
            System.out.println("Fruta: " + fruta);
        }

        // Nested for loop
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("(%d,%d) ", i, j);
            }
            System.out.println();
        }
    }

    public void demonstrateWhileLoops() {
        // While loop
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }

        // Do-while loop
        int num = 1;
        do {
            System.out.println("Número: " + num);
            num *= 2;
        } while (num <= 8);
    }

    public void demonstrateControlFlow() {
        // Break example
        for (int i = 0; i < 10; i++) {
            if (i == 5) break;
            System.out.println(i);
        }

        // Continue example
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            System.out.println(i);
        }

        // Label example
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i * j > 4) break outer;
                System.out.printf("(%d,%d) ", i, j);
            }
        }
    }
}