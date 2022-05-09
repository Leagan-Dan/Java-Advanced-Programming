package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from City e order by e.id"),
})

public class City implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name="country")
    private String country;
    @Column (name="name")
    private String name;
    @Column(name = "capital")
    private int capital;
    @Column(name="latitude")
    private float latitude;
    @Column(name="longitude")
    private float longitude;

    public City() {
    }

    public City(String country, String name, int capital, float latitude, float longitude) {
        this.country = country;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "\nCity{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
