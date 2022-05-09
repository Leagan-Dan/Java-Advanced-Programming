package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="continents")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from Continent e order by e.name"),
})

public class Continent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column (name="name")
    private String name;

    public Continent() {
    }

    public Continent(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nContinent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
