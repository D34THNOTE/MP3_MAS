package models.abstractPolymorphism;

public abstract class MediaItem {

    private String name, genre;

    public MediaItem(String name, String genre) {
        setName(name);
        setGenre(genre);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Media item's name is required");

        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(genre == null || genre.isBlank()) throw new IllegalArgumentException("Media item's genre is required");

        this.genre = genre;
    }

    public abstract String displayInfo();
}
