package io.github.libai8723;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ConcertConfig {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("io.github.libai8723");
        Performance p = (Performance) ctx.getBean("music");
        Encoreable encoreable = (Encoreable) p;
        p.perform();
        encoreable.performEncore();
    }

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}

