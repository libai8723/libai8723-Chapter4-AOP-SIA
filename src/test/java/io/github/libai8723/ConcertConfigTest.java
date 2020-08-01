package io.github.libai8723;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class ConcertConfigTest {

    @Rule
    public final SystemOutRule rule = new SystemOutRule().enableLog();

    @Autowired
    private Performance performance;

    @Test
    public void testPerformance(){
        performance.perform();
        assertEquals("Silencing cell phones\n" +
                "Taking seats\n" +
                "Piano Solo\n" +
                "CLAP CLAP CLAP!!!\n", rule.getLog());
    }
}
