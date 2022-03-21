package Item;

public class Book extends Item{
    private String author;
    private int year;

    public Book(String author, int year, int id, String name, String location) {
        this.author = author;
        this.year = year;
        this.id = id;
        this.name =name;
        this.location=location;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", year=" + year +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}' + '\n';
    }
}