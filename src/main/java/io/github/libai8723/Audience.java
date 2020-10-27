package io.github.libai8723;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    /**
     * The value given to the @Pointcut annotation is a pointcut expression, just like the ones you
     * used previously with the advice annotations. By annotating performance() with @Pointcut in this way,
     * you essentially extend the pointcut expression language so that
     * you can use performance() in your pointcut expressions anywhere you’d otherwise
     * use the longer expression. As you can see, you replace the longer expression in all the
     * advice annotations with performance().
     *
     * The body of the performance() method is irrelevant and, in fact, should be
     * empty. The method itself is just a marker, giving the @Pointcut annotation something
     * to attach itself to
     */
    @Pointcut(value = "execution(* io.github.libai8723.Performance.perform(..))")
    public void performance() {}

    // the same meaning with the longer expression
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("[Around Advice]: Silencing the cell phones");
            System.out.println("[Around Advice]: Taking seats");
            System.out.println("[Around Advice]: Before execute the advised method, method signature is: " + jp.getSignature().toLongString());
            jp.proceed();
            System.out.println("[Around Advice]: CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("[Around Advice]: Demanding a refund");
        }
    }
}
