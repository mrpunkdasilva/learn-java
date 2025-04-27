package com.netrunner.processor;

import com.google.auto.service.AutoService;
import com.netrunner.annotations.Builder;
import com.netrunner.annotations.Mapper;
import com.netrunner.annotations.ValidateAnnotation;
import com.squareup.javapoet.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@AutoService(Processor.class)
@SupportedAnnotationTypes({
    "com.netrunner.annotations.Builder",
    "com.netrunner.annotations.Mapper",
    "com.netrunner.annotations.ValidateAnnotation"
})
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class CustomProcessor extends AbstractProcessor {
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        processBuilderAnnotation(roundEnv);
        processMapperAnnotation(roundEnv);
        processValidateAnnotation(roundEnv);
        return true;
    }

    private void processBuilderAnnotation(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Builder.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                reportError(element, "@Builder can only be applied to classes");
                continue;
            }

            TypeElement typeElement = (TypeElement) element;
            String className = typeElement.getSimpleName().toString();
            String packageName = processingEnv.getElementUtils()
                .getPackageOf(typeElement).toString();

            Builder annotation = element.getAnnotation(Builder.class);
            String builderClassName = annotation.builderClassName().isEmpty() 
                ? className + "Builder" 
                : annotation.builderClassName();

            try {
                generateBuilder(typeElement, packageName, builderClassName);
            } catch (IOException e) {
                reportError(element, "Failed to generate builder: " + e.getMessage());
            }
        }
    }

    private void generateBuilder(TypeElement typeElement, String packageName, String builderClassName) 
            throws IOException {
        TypeSpec.Builder builder = TypeSpec.classBuilder(builderClassName)
            .addModifiers(Modifier.PUBLIC);

        // Add private field for the target class
        FieldSpec instance = FieldSpec.builder(
            TypeName.get(typeElement.asType()),
            "instance",
            Modifier.PRIVATE
        )
        .initializer("new $T()", TypeName.get(typeElement.asType()))
        .build();
        
        builder.addField(instance);

        // Generate setter methods for each field
        for (Element enclosed : typeElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.FIELD) {
                VariableElement field = (VariableElement) enclosed;
                String fieldName = field.getSimpleName().toString();
                TypeName fieldType = TypeName.get(field.asType());

                MethodSpec setter = MethodSpec.methodBuilder(fieldName)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(ClassName.get(packageName, builderClassName))
                    .addParameter(fieldType, fieldName)
                    .addStatement("this.instance.$L = $L", fieldName, fieldName)
                    .addStatement("return this")
                    .build();

                builder.addMethod(setter);
            }
        }

        // Add build method
        MethodSpec buildMethod = MethodSpec.methodBuilder("build")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.get(typeElement.asType()))
            .addStatement("return instance")
            .build();

        builder.addMethod(buildMethod);

        // Write the file
        JavaFile javaFile = JavaFile.builder(packageName, builder.build())
            .build();

        javaFile.writeTo(processingEnv.getFiler());
    }

    private void processMapperAnnotation(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Mapper.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                reportError(element, "@Mapper can only be applied to classes");
                continue;
            }

            TypeElement typeElement = (TypeElement) element;
            Mapper annotation = element.getAnnotation(Mapper.class);

            try {
                generateMapper(typeElement, annotation);
            } catch (IOException e) {
                reportError(element, "Failed to generate mapper: " + e.getMessage());
            }
        }
    }

    private void generateMapper(TypeElement typeElement, Mapper annotation) throws IOException {
        String className = typeElement.getSimpleName().toString();
        String packageName = processingEnv.getElementUtils().getPackageOf(typeElement).toString();
        String dtoPackage = annotation.dtoPackage().isEmpty() ? packageName + ".dto" : annotation.dtoPackage();
        String mapperPackage = annotation.mapperPackage().isEmpty() ? packageName + ".mapper" : annotation.mapperPackage();

        // Generate DTO class
        TypeSpec dto = generateDtoClass(typeElement, className + "DTO");
        JavaFile dtoFile = JavaFile.builder(dtoPackage, dto).build();
        dtoFile.writeTo(processingEnv.getFiler());

        // Generate Mapper class
        TypeSpec mapper = generateMapperClass(typeElement, className + "Mapper", dtoPackage + "." + className + "DTO");
        JavaFile mapperFile = JavaFile.builder(mapperPackage, mapper).build();
        mapperFile.writeTo(processingEnv.getFiler());
    }

    private TypeSpec generateDtoClass(TypeElement typeElement, String dtoClassName) {
        TypeSpec.Builder dtoBuilder = TypeSpec.classBuilder(dtoClassName)
            .addModifiers(Modifier.PUBLIC);

        // Add fields from original class
        for (Element enclosed : typeElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.FIELD) {
                VariableElement field = (VariableElement) enclosed;
                dtoBuilder.addField(
                    FieldSpec.builder(
                        TypeName.get(field.asType()),
                        field.getSimpleName().toString(),
                        Modifier.PRIVATE
                    ).build()
                );
            }
        }

        return dtoBuilder.build();
    }

    private TypeSpec generateMapperClass(TypeElement typeElement, String mapperClassName, String dtoClassName) {
        return TypeSpec.classBuilder(mapperClassName)
            .addModifiers(Modifier.PUBLIC)
            .addMethod(MethodSpec.methodBuilder("toDto")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(ClassName.bestGuess(dtoClassName))
                .addParameter(TypeName.get(typeElement.asType()), "entity")
                .addStatement("// TODO: Implement mapping logic")
                .addStatement("return new $T()", ClassName.bestGuess(dtoClassName))
                .build())
            .build();
    }

    private void processValidateAnnotation(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(ValidateAnnotation.class)) {
            if (element.getKind() != ElementKind.ANNOTATION_TYPE) {
                reportError(element, "@ValidateAnnotation can only be applied to annotations");
                continue;
            }

            validateAnnotationType((TypeElement) element);
        }
    }

    private void validateAnnotationType(TypeElement annotationType) {
        // Validate annotation methods/parameters
        for (Element element : annotationType.getEnclosedElements()) {
            if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement method = (ExecutableElement) element;
                validateAnnotationMethod(method);
            }
        }
    }

    private void validateAnnotationMethod(ExecutableElement method) {
        TypeMirror returnType = method.getReturnType();
        // Add validation logic for annotation methods
        // For example, check if return types are valid for annotations
    }

    private void reportError(Element element, String message) {
        processingEnv.getMessager().printMessage(
            Diagnostic.Kind.ERROR,
            message,
            element
        );
    }
}