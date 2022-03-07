package compulsory;

public class Router extends Node implements Identifiable{
    private String iPAddress;
    public Router() {
    }

    //constructor pentru un obiect de tipul Router
    public Router(String IPAddress, String name, String hardwareAddress, String location) {
        super(name,hardwareAddress,location);
        this.iPAddress = IPAddress;
    }

    //seteaaza adresa IP
    public void setIPAddress(String IPAddress) {
        this.iPAddress = IPAddress;
    }

    //returneazaz adresa IP
    @Override
    public String getIPAddress() {
        return iPAddress;
    }


    //override la toString pentru a afisa un obiect de tipul Router
    @Override
    public String toString() {
        return "Router{IP-address: " + getIPAddress() + ", location: " + getLocation() + ", hardware address: " + getHardwareAddress() + ", name: " + getName() + "}" + '\n';
    }
}