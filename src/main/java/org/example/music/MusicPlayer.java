package org.example.music;

public class MusicPlayer {

    private Music music;
    private String name;
    private int volume;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() { }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    public Music getMusic() {
        return music;
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

    public void setMusic(Music music) {
        this.music = music;
    }
}
