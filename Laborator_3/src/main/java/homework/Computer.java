package homework;

public class Computer extends Node implements Storage, Identifiable {
    private String IPAdress;
    private long storageCapacity;

    public Computer() {
    }

    public Computer(String IPAdress, int storageCapacity, String name, String hardwareAdress, String location) {
        super(name, hardwareAdress, location);
        this.IPAdress = IPAdress;
        this.storageCapacity = storageCapacity;
    }

    public void setIPAdress(String IPAdress) {
        this.IPAdress = IPAdress;
    }


    @Override
    public String getIPAdress() {
        return IPAdress;
    }

    @Override
    public long getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer {IP-address: " + getIPAdress() + ", storageCapacity: " + getStorageCapacity() + ", location: "
                + getLocation() + ", hardware address: " + getHardwareAdress() + ", name: " + getName() + "}" + '\n';
    }

}
