package com.example.firstSpringApp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Indicates where the annotation can be used (e.g., methods)
@Retention(RetentionPolicy.RUNTIME) // Indicates how long the annotation information is retained (e.g., runtime)
public @interface CustomAnnotation {
    String value() default "x"; // Define attributes for the annotation
}
