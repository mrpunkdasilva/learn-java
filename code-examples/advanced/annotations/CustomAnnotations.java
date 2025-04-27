// Runtime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
    String table() default "";
}

// Compile-time annotation
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface Generated {
    String value() default "";
}

// Custom annotation with elements
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Validate {
    String message() default "Invalid value";
    int min() default 0;
    int max() default Integer.MAX_VALUE;
    boolean required() default true;
}

// Usage example
@Entity(table = "users")
public class User {
    @Validate(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    
    @Validate(required = true, message = "Email is required")
    private String email;
    
    @Generated
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}

// Annotation processor
@SupportedAnnotationTypes("com.example.annotations.*")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class CustomAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, 
                         RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            Set<? extends Element> elements = 
                roundEnv.getElementsAnnotatedWith(annotation);
            
            for (Element element : elements) {
                // Process each annotated element
                processAnnotation(element);
            }
        }
        return true;
    }
}