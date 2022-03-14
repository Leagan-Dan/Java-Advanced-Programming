package homework;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Computer v1 = new Computer("A5C", 20, "ComputerA", "AW", "v1");
        Router v2 = new Router("B4C", "RouterA", "AV", "v2");
        Switch v3 = new Switch(45, "SwitchA", "AZ", "v3");
        Switch v4 = new Switch(45, "SwitchB", "AZ", "v4");
        Router v5 = new Router("B4C", "RouterB", "AV", "v5");
        Computer v6 = new Computer("A4C", 30, "ComputerB", "AW", "v6");

        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);
        System.out.println(network);

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        network.getCosts();
        System.out.println(v1.getConvertedStorageCapacity());
        network.displayIdentifiable();
        System.out.println(network.findShortestTime(v1, v6));
    }
}
