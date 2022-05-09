package entities;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="countries")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select e from Country e order by e.name"),
})
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column (name="name")
    private String name;
    @Column (name="code")
    private Integer code;
    @Column(name="continent")
    private String continent;


    public Country() {
    }

    public Country(String name, Integer code, String continent) {
        this.name = name;
        this.code = code;
        this.continent = continent;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "\n Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", continent='" + continent + '\'' +
                '}';
    }

}

