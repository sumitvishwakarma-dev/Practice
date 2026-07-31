package com.example.DemoAspect.aspects;

import com.example.DemoAspect.dto.Student;
import com.example.DemoAspect.services.DemoService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DecoratorAspects  {

    private DemoService demoService;

    DecoratorAspects(DemoService demoService){
        this.demoService = demoService;
    }

    @Pointcut("execution(public * com.example.DemoAspect.services.DemoService.createStudent(..))")
    public void createStudentPointcut(){

    }

// "With Execution:"   @Before("execution(* " +
//            "com.example.DemoAspect.services.DemoService.*" +
//            "(..))")

// "with Within:"        @Before("within(com.example.DemoAspect.services..*)")

// "With Annotation:"    @Before("@annotation(jdk.jfr.Timestamp)")
// "With Bean:"          @Before("bean(demoService)")

//    @Before("within(com.example.DemoAspect.services..*) " +
//            "&& " +
//            "execution(public * * (..))")
//    public void logBeforeMethod(){
//            System.out.println("In the AOP ....");
//    }


//    @Around("execution(* com.example.DemoAspect.services.DemoService.greetStudent(..))")
    @Around("createStudentPointcut()")
    public Object feedAndReturn(
            ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable {
        System.out.println("Before In Around .. ");
        long startTime = System.currentTimeMillis();
        Object[] args = proceedingJoinPoint.getArgs();

        for(Object arg : args){
            System.out.println(arg);
            if(arg instanceof Student){
                Student student = (Student) arg;
                if (student.getName() != null && !student.getName().equals("")){
                    String name = student.getName().trim().toUpperCase();
                    student.setName(name);
                }
            }
        }
        Object result;
        try{
            result = proceedingJoinPoint.proceed(args);
            System.out.println("After: Student created successfully -> " + result);

        } catch (Throwable e) {
            System.out.println("Exception in Around : "+e.getMessage());
            throw new RuntimeException(e);
        }
        finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Time Taken: "+(endTime - startTime));
        }
        return result;
    }



}
