package Item;

public class Article extends Item {
    private String theme;


    public Article(String theme, int id, String name, String location) {
        this.theme = theme;
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Article{" +
                "theme='" + theme + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}' + '\n';
    }

}
