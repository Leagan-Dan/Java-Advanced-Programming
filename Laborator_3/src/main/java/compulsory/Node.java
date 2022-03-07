package compulsory;

public abstract class Node implements Comparable<Node>{
    private String name;
    private String hardwareAddress;
    private String location;

    public Node() {
    }

    //constructor pentru un obiect de tipul Node
    public Node(String name, String hardwareAddress, String location) {
        this.name = name;
        this.hardwareAddress = hardwareAddress;
        this.location = location;
    }

    //retureneaza un nume
    public String getName() {
        return name;
    }

    //seteaza un nume
    public void setName(String name) {
        this.name = name;
    }

    //returneaza o adresa hardware
    public String getHardwareAddress() {
        return hardwareAddress;
    }

    //seteaza o adresa hardware
    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    //returneaza locatia
    public String getLocation() {
        return location;
    }

    //seteaza o locatie
    public void setLocation(String location) {
        this.location = location;
    }

    //override la compareTo pentru a compara numele fiecarui obiect
    @Override
    public int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }

    //override la toString pentru a afisa un obiect de tipul Node
    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", location='" + location + '\'' +
                '}'+ '\n';
    }
}
