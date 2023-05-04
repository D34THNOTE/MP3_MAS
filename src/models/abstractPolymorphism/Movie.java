package models.abstractPolymorphism;

public class Movie extends MediaItem {

    private String director;

    public Movie(String name, String genre, String director) {
        super(name, genre);
        setDirector(director);
    }

    @Override
    public String displayInfo() {
        return "Movie's name is: " + getName() + ", it is a " + getGenre() + " movie directed by " + this.director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if(director == null || director.isBlank()) throw new IllegalArgumentException("Movie's director is required");

        this.director = director;
    }
}
