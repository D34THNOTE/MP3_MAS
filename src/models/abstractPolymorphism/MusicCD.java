package models.abstractPolymorphism;

public class MusicCD extends MediaItem {

    private String artist;

    public MusicCD(String name, String genre, String artist) {
        super(name, genre);
        setArtist(artist);
    }

    @Override
    public String displayInfo() {
        return "CD's name is: " + getName() + ", it is a " + getGenre() + " album performed by " + this.artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if(artist == null || artist.isBlank()) throw new IllegalArgumentException("CD's artist is required");

        this.artist = artist;
    }
}
