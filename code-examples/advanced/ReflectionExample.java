public class ReflectionExample {
    public void demonstrateReflection() throws Exception {
        // Get class information
        Class<?> clazz = Class.forName("com.example.MyClass");
        
        // Create instance
        Object instance = clazz.getDeclaredConstructor().newInstance();
        
        // Get methods
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Parameters: " + Arrays.toString(method.getParameters()));
        }
        
        // Invoke method
        Method method = clazz.getDeclaredMethod("doSomething", String.class);
        method.setAccessible(true);
        Object result = method.invoke(instance, "test");
        
        // Access fields
        Field field = clazz.getDeclaredField("privateField");
        field.setAccessible(true);
        field.set(instance, "new value");
        
        // Get annotations
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation: " + annotation);
        }
    }
}