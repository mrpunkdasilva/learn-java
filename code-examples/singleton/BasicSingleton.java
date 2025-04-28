public class BasicSingleton {
    private static BasicSingleton instance;
    
    private BasicSingleton() {}
    
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
}