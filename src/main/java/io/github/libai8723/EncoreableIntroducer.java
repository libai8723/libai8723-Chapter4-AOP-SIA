package io.github.libai8723;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "io.github.libai8723.Performance+", defaultImpl = EncoreableImpl.class)
    public static Encoreable encoreable;
}
