package org.example;

import org.example.music.Music;
import org.springframework.beans.factory.annotation.Value;

public class MusicPlayer {

    private Music music;

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.print("Playing: " + music.getSong());
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}
