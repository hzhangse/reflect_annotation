package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;   
  
@Retention(RetentionPolicy.RUNTIME)   
public @interface RetentionTest {   
    String hello() default "hello";   
    String world();   
}   