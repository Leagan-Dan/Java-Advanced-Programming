package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String hardwareAdress;
    private String location;
    boolean visited;
    private Map<Node, Integer> cost = new HashMap<>();
    private List<Node> adjacentNodes = new ArrayList<>();

    public Node() {
    }

    public Node(String name, String hardwareAdress, String location) {
        this.name = name;
        this.hardwareAdress = hardwareAdress;
        this.location = location;
        this.visited = false;
    }

    //parcurge map-ul cost pentru nodul curent, afisand fiecare nod cu care acesta e adiacent, si costul
    public void printCost() {
        for (Node key : cost.keySet()) {
            System.out.println(this.location + "--" + key.getLocation() + ' ' + cost.get(key));
        }
    }

    public int getCost(Node o) {
        return cost.get(o);
    }

    public void setCost(Node node, int value) {
        adjacentNodes.add(node);
        cost.put(node, value);
    }

    public void addAdjacentNodes(Node node) {
        adjacentNodes.add(node);
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHardwareAdress() {
        return hardwareAdress;
    }

    public void setHardwareAdress(String hardwareAdress) {
        this.hardwareAdress = hardwareAdress;
    }

    public String getLocation() {
        return location;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int compareTo(Node o) {
        if (this instanceof Identifiable && o instanceof Identifiable) {
            return ((Identifiable) this).getIPAdress().compareTo(((Identifiable) o).getIPAdress());
        }
        return 0;
        //return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", hardwareAdress='" + hardwareAdress + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
