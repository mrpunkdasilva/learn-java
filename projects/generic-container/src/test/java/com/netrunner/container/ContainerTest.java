package com.netrunner.container;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    
    @Test
    void testBasicOperations() {
        Container<String> container = new Container<>();
        
        container.add("test1");
        container.addNamed("key1", "test2");
        
        assertEquals("test1", container.get(0).orElse(null));
        assertEquals("test2", container.getNamed("key1").orElse(null));
    }
    
    @Test
    void testValidatedContainer() {
        ValidatedContainer<String> container = 
            new ValidatedContainer<>(s -> s != null && !s.isEmpty());
        
        container.add("valid");
        assertThrows(IllegalArgumentException.class, () -> container.add(""));
        assertThrows(IllegalArgumentException.class, () -> container.add(null));
    }w
    
    @Test
    void testTransformingContainer() {
        Container<String> source = new Container<>();
        source.add("123");
        source.addNamed("num", "456");
        
        TransformingContainer<String, Integer> transformer = 
            new TransformingContainer<>(source, Integer::parseInt);
        
        assertEquals(123, transformer.getTransformed(0).orElse(0));
        assertEquals(456, transformer.getNamedTransformed("num").orElse(0));
    }
    
    @Test
    void testThreadSafeContainer() {
        ThreadSafeContainer<Integer> container = new ThreadSafeContainer<>();
        
        container.add(1);
        container.addNamed("first", 2);
        
        assertEquals(1, container.get(0).orElse(0));
        assertEquals(2, container.getNamed("first").orElse(0));
    }
}