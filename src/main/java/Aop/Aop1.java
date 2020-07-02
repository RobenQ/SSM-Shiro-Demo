package Aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aop1{

    @Pointcut("execution(* controller..*.*(..))")
    public void aop(){};

    @Before("aop()")
    public void sayOk(){
        System.out.println("before");
    }

    @After("execution(* controller..*.*(..))")
    public void sayOk2(){
        System.out.println("after");
    }

}
