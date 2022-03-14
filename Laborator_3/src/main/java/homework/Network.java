package homework;

import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    private Map<Node, Integer> shortestTime = new HashMap<>();
    private Map<Node, Node> previousNode = new HashMap<>();

    public Network() {

    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void getCosts() {
        for (int index = 0; index < nodes.size(); index++) {
            nodes.get(index).printCost();
        }
    }

    //sorteaza si afiseaza obiectele Identifiable, adaugandu-le intr-o alta lista si sortand-o
    public void displayIdentifiable() {
        List<Node> identifiables = new ArrayList<>();
        for (int index = 0; index < nodes.size(); index++) {
            if (nodes.get(index) instanceof Identifiable) {
                identifiables.add(nodes.get(index));
            }
        }

        Collections.sort(identifiables);
        System.out.println(identifiables);
    }

    /*Algoritmul Dijkstra. Pentru fiecare nod, am folosit un map care marcheaza costul de la nodul de start, la acesta.
    De asemenea, am folosit un map care retine pentru nodul curent, nodul din care am ajuns in el (nodul precedent).
    Nodurile vecine nodului curent, cat si costul dintre acestea sunt retinute in clasa Node. Algoritmul merge
    pe strada cu costul cel mai mic, si actualizeaza cele 2 map-uri cu nodul precedent, si costurile adunate.
    Pentru urmatorul nod, algoritmul se repeta. Se opreste cand toate nodurile au fost vizitate, sau cand nodul curent
    este nodul pe care il cautam.*/
    public int findShortestTime(Node startNode, Node finishNode) {
        for (int index1 = 0; index1 < nodes.size(); index1++) {
            shortestTime.put(nodes.get(index1), 1000);
        }
        int rememberIndex = 0;
        Node currentNode = startNode;
        currentNode.setVisited(true);
        int visited = 1;
        int auxCost = 0;
        while (visited <= 6) {
            int minCost = 1000;
            for (int index = 0; index < currentNode.getAdjacentNodes().size(); index++) {
                int newCost = currentNode.getCost(currentNode.getAdjacentNodes().get(index));
                int oldCost = shortestTime.get(currentNode.getAdjacentNodes().get(index));
                Node newNode = currentNode.getAdjacentNodes().get(index);
                if (newCost < oldCost) {
                    shortestTime.put(newNode, (newCost + auxCost));
                    previousNode.put(newNode, currentNode);
                    auxCost = newCost;
                    if (!newNode.isVisited() && newCost < minCost) {
                        rememberIndex = index;
                        minCost = newCost;
                    }
                }
            }
            for (int index = 0; index < currentNode.getAdjacentNodes().size(); index++)
                if (index == rememberIndex) {
                    currentNode = currentNode.getAdjacentNodes().get(index);
                    currentNode.setVisited(true);
                    visited++;
                }
            if (finishNode == currentNode)
                break;
        }
        return shortestTime.get(finishNode);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodes +
                '}';
    }
}
