package models.abstractPolymorphism;

public class Book extends MediaItem {

    private String author;

    public Book(String name, String genre, String author) {
        //TODO test constructor for invalid input
        super(name, genre);
        setAuthor(author);
    }

    @Override
    public String displayInfo() {
        return "Book's name is: " + getName() + ", it is a " + getGenre() + " book written by " + this.author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isBlank()) throw new IllegalArgumentException("Book's author is required");

        this.author = author;
    }
}
