package com.example.demoCustomSpringAOP.annotations;


import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EvaluateExecutionTimeAOP {

     long warnTime() default 2000;
     String operation() default "";


}
