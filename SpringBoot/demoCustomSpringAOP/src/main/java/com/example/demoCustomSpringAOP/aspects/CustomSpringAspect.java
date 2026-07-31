package com.example.demoCustomSpringAOP.aspects;

import com.example.demoCustomSpringAOP.annotations.EvaluateExecutionTimeAOP;
import com.example.demoCustomSpringAOP.annotations.MakeItUpperCase;
import com.example.demoCustomSpringAOP.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomSpringAspect {

    @Around("@annotation(evaluateExecutionTimeAOP)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint,
                                   EvaluateExecutionTimeAOP evaluateExecutionTimeAOP) throws Throwable {

        System.out.println("In Method Interceptor");
        long startTime = System.currentTimeMillis();

        try{
           return joinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            long warningTime = evaluateExecutionTimeAOP.warnTime();
            String operation = evaluateExecutionTimeAOP.operation();

            if (duration >= warningTime ){
                System.out.println("Slow operation "+operation+ " : warning time was " +warningTime+
                        "but time taken "+duration);
            }else {
                System.out.println(operation+ " : warning time was " +warningTime+
                        "but time taken "+duration);
            }
            if(operation.isBlank()){
                operation = joinPoint.getSignature().getName();
                System.out.println(operation);
            }

        }
    }

    @Around("@annotation(makeItUpperCase)")
    public Object makeItUpper(ProceedingJoinPoint proceedingJoinPoint,
                              MakeItUpperCase makeItUpperCase) throws Throwable{

        System.out.println("MakeItUppercase start");
        long startTime = System.currentTimeMillis();
        long warningTime = makeItUpperCase.warnTime();
        try{
           Object[] args = proceedingJoinPoint.getArgs();
           for(Object arg : args){
               if (arg instanceof Student){
                   Student student = (Student) arg;
                   if(student.getName() != null && !student.getName().equals("")){
                       String name = student.getName().trim().toUpperCase();
                       student.setName(name);
                   }
               }
           }
           return proceedingJoinPoint.proceed(args);

        }
        finally {
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                if (duration>=warningTime){
                    System.out.println("Time Exceeded warning time is "+ warningTime+
                            " less than duration "+duration);
                }

            System.out.println("MakeItUppercase end");
        }
    }


}
