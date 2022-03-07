package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network{
    private List<Node> nodes = new ArrayList<>();

    public Network(){

    }
    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    //sorteaza nodurile din lista dupa metoda compareTo
    public void sortNodes(){
        Collections.sort(nodes);
    }

    //adauga un nod in lista cu noduri
    public void addNode(Node node){
        nodes.add(node);
    }

    //returneaza lista cu noduri
    public List<Node> getNodes() {
        return nodes;
    }

    //inlocuieste lista cu noduri
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    //override la toString pentru a afisa lista cu noduri
    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodes +
                '}' + '\n';
    }
}