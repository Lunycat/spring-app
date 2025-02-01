package org.example.music;

import java.util.List;

public class MusicPlayer {

    private List<Music> musics;
    private String name;
    private int volume;

    public MusicPlayer(List<Music> musics) {
        this.musics = musics;
    }

    public MusicPlayer() { }

    public void playMusic() {
        System.out.print("Playing: ");
        for (Music music : musics) {
            System.out.print(music.getSong() + " ");
        }
        System.out.println();
    }

    public List<Music> getMusic() {
        return musics;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusic(List<Music> musics) {
        this.musics = musics;
    }
}
