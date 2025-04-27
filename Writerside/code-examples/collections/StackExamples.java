public class StackExamples {
    public void demonstrateStacks() {
        // Stack tradicional (legado)
        Stack<String> stack = new Stack<>();
        stack.push("Primeiro");
        stack.push("Segundo");
        stack.pop();     // Remove e retorna
        stack.peek();    // Retorna sem remover
        
        // Deque como Stack (recomendado)
        Deque<Integer> dequeStack = new ArrayDeque<>();
        dequeStack.push(1);
        dequeStack.push(2);
        dequeStack.pop();
        dequeStack.peek();
        
        // Exemplo de uso prático
        public boolean isBalanced(String expression) {
            Deque<Character> stack = new ArrayDeque<>();
            
            for (char c : expression.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            
            return stack.isEmpty();
        }
    }
}