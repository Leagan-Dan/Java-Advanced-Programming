package compulsory;

public class Switch extends Node implements Storage{
    private int storageCapacity;

    public Switch() {
    }

    //constructor pentru un obiect de tipul Switch
    public Switch(int storageCapacity, String name, String hardwareAddress, String location) {
        super(name,hardwareAddress,location);
        this.storageCapacity = storageCapacity;
    }

    //seteaza capacitatea
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    //returneaza capacitatea
    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }


    //override la toString pentru a afisa un obiect de tipul Switch
    @Override
    public String toString() {
        return "Switch{storageCapacity: " + getStorageCapacity() + ", location: " + getLocation() + ", hardware address: " + getHardwareAddress() + ", name: " + getName() + "}" + '\n';
    }
}
