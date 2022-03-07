package compulsory;

public class Computer extends Node implements Storage, Identifiable {
    private String IPAddress;
    private int storageCapacity;

    public Computer() {
    }

    //constructor pentru un obiect de tip computer
    public Computer(String IPAddress, int storageCapacity, String name, String hardwareAddress, String location) {
        super(name, hardwareAddress, location);
        this.IPAddress = IPAddress;
        this.storageCapacity = storageCapacity;
    }

    //seteaza adresa IP
    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    //returneaza adresa IP
    @Override
    public String getIPAddress() {
        return IPAddress;
    }

    //returneaza capacitatea
    @Override
    public int getStorageCapacity() {return storageCapacity;}

    //override la toString pentru a afisa un obiect de tipul Computer
    @Override
    public String toString() {
        return "Computer {IP-address: " + getIPAddress() + ", storageCapacity: " + getStorageCapacity() + ", location: " + getLocation() + ", hardware address: " + getHardwareAddress() + ", name: " + getName() + "}" + '\n';
    }

}