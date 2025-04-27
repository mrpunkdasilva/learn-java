public class ArrayExamples {
    public void demonstrateArrays() {
        // Array unidimensional
        int[] numeros = new int[5];
        numeros[0] = 10;
        numeros[1] = 20;
        
        // Inicialização direta
        String[] nomes = {"João", "Maria", "Pedro"};
        
        // Array multidimensional
        int[][] matriz = new int[3][3];
        matriz[0][0] = 1;
        matriz[1][1] = 5;
        
        // Array multidimensional com inicialização
        int[][] tabuleiro = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Operações com Arrays
        Arrays.sort(numeros);  // Ordenação
        int posicao = Arrays.binarySearch(numeros, 20);  // Busca
        int[] copia = Arrays.copyOf(numeros, numeros.length);  // Cópia
        
        // Iteração
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        
        // For-each
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}