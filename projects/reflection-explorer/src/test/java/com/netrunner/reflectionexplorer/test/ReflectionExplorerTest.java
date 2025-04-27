package com.netrunner.reflectionexplorer.test;

import com.netrunner.reflectionexplorer.analyzer.ClassAnalyzer;
import com.netrunner.reflectionexplorer.core.ReflectionExplorer;
import com.netrunner.reflectionexplorer.model.ClassInfo;
import com.netrunner.reflectionexplorer.modifier.ObjectModifier;
import com.netrunner.reflectionexplorer.proxy.ProxyGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionExplorerTest {
    private ReflectionExplorer explorer;
    
    @BeforeEach
    void setUp() {
        explorer = new ReflectionExplorer(
            new ClassAnalyzer(),
            new ObjectModifier(),
            new ProxyGenerator()
        );
    }
    
    @Test
    void testClassAnalysis() {
        ClassInfo info = explorer.analyze(TestClass.class);
        
        assertNotNull(info);
        assertEquals("TestClass", info.getName());
        assertTrue(info.getMethods().length > 0);
    }
    
    @Test
    void testObjectModification() {
        TestClass instance = new TestClass();
        Enhancement enhancement = new Enhancement("value", "newValue");
        
        Object modified = explorer.modify(instance, enhancement);
        
        assertEquals("newValue", ((TestClass)modified).getValue());
    }
    
    @Test
    void testProxyGeneration() {
        TestInterface original = new TestInterfaceImpl();
        TestInterface proxy = explorer.createProxy(
            TestInterface.class,
            new ProxyGenerator.LoggingHandler(original)
        );
        
        String result = proxy.doSomething();
        assertEquals("done", result);
    }
}

interface TestInterface {
    String doSomething();
}

class TestInterfaceImpl implements TestInterface {
    @Override
    public String doSomething() {
        return "done";
    }
}

class TestClass {
    private String value = "oldValue";
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}