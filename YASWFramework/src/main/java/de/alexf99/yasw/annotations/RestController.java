package de.alexf99.yasw.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

// Muss in einer Datei namens MyController.java gespeichert werden
@Retention(RetentionPolicy.CLASS)
@Target(TYPE)
public @interface RestController {
    String value() default ""; // Optionale Basis-URL
}
