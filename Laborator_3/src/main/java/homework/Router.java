package homework;

public class Router extends Node implements Identifiable {
    private String IPAdress;

    public Router() {
    }

    public Router(String IPAdress, String name, String hardwareAdress, String location) {
        super(name, hardwareAdress, location);
        this.IPAdress = IPAdress;
    }

    public void setIPAdress(String IPAdress) {
        this.IPAdress = IPAdress;
    }

    @Override
    public String getIPAdress() {
        return IPAdress;
    }

    @Override
    public String toString() {
        return "Router{IP-address: " + getIPAdress() + ", location: " + getLocation() + ", hardware address: "
                + getHardwareAdress() + ", name: " + getName() + "}" + '\n';
    }
}
