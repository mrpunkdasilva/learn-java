package com.netrunner.processor;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.CompilationSubject;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.Test;

import javax.tools.JavaFileObject;

class CustomProcessorTest {

    @Test
    void testBuilderGeneration() {
        JavaFileObject source = JavaFileObjects.forSourceString(
            "com.example.Test",
            "package com.example;\n" +
            "\n" +
            "import com.netrunner.annotations.Builder;\n" +
            "\n" +
            "@Builder\n" +
            "public class Test {\n" +
            "    private String name;\n" +
            "    private int age;\n" +
            "}"
        );

        Compilation compilation = Compiler.javac()
            .withProcessors(new CustomProcessor())
            .compile(source);

        CompilationSubject.assertThat(compilation).succeeded();
        CompilationSubject.assertThat(compilation)
            .generatedSourceFile("com.example.TestBuilder");
    }
}