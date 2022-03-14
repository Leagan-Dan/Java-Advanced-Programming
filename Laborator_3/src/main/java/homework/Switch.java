package homework;

public class Switch extends Node implements Storage {
    private long storageCapacity;

    public Switch() {
    }

    public Switch(int storageCapacity, String name, String hardwareAdress, String location) {
        super(name, hardwareAdress, location);
        this.storageCapacity = storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }


    @Override
    public long getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public String toString() {
        return "Switch{storageCapacity: " + getStorageCapacity() + ", location: " + getLocation() + ", " +
                "hardware address: " + getHardwareAdress() + ", name: " + getName() + "}" + '\n';
    }
}
