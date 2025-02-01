package org.example.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

    @Autowired
    @Qualifier("classicMusic")
    private Music music;

    public void playMusic() {
        System.out.print("Playing: " + music.getSong());
    }
}
