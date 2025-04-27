module com.example.myapp {
    // Exports
    exports com.example.myapp.api;
    exports com.example.myapp.model to com.example.other;
    
    // Requires
    requires java.base;  // implicit
    requires java.sql;
    requires transitive com.example.shared;
    
    // Services
    uses com.example.spi.MyService;
    provides com.example.spi.MyService with com.example.myapp.MyServiceImpl;
}