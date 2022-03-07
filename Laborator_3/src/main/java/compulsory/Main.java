package compulsory;

public class Main {
    public static void main(String[] args) {
        Network network=new Network();
        Computer computer1=new Computer("A5C",30,"Computer","AW","location1");
        Router router1=new Router("B4C","Router","AV","location2");
        Switch switch1=new Switch(45,"A","AZ","location3");

        network.addNode(computer1);
        network.addNode(router1);
        network.addNode(switch1);
        network.sortNodes();

        System.out.println(network);
    }
}