package io.github.libai8723.handleparameter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc blankDisc(){
        BlankDisc cd = new BlankDisc();
        cd.setTitle("rolling in the deep!!!");
        cd.setArtist("Adele");

        HashMap<Integer, String> tracks = new HashMap<>();
        tracks.put(1, "rolling in the deep");
        tracks.put(2, "there is a fire starting in my heart");
        tracks.put(3, "someone like you");
        cd.setTracks(tracks);

        return  cd;
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("io.github.libai8723.handleparameter");
        CompactDisc cd = ctx.getBean(CompactDisc.class);

        cd.play();

        cd.play();

        cd.playTrack(1);
        cd.playTrack(1);

        cd.playTrack(1);

        TrackCounter tc = ctx.getBean(TrackCounter.class);
        System.out.println(tc.getPlayCount(1));
        System.out.println(tc.getPlayCount(2));
        System.out.println(tc.getPlayCount(3));


    }
}
