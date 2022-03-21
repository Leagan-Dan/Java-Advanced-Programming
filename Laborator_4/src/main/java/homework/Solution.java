package homework;

import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.*;
import java.util.LinkedList;

public class Solution {
    private List<Street> streetList = new LinkedList<>();
    private Set<Intersection> intersectionSet = new HashSet<>();
    private Map <Street, List<Intersection>> streetWithIntersections= new HashMap<>();

    public Solution() {
    }

    public Map<Street, List<Intersection>> getStreetWithIntersections() {
        return streetWithIntersections;
    }

    public void addStreet(Street o){
        streetList.add(o);
    }

    public void addIntersection(Intersection o){
        intersectionSet.add(o);
    }

    public void printIntersectionSet(){
        for(Intersection intersection:intersectionSet){
            System.out.println(intersection.getName());
        }
    }

    /**
     * Sort the street by their length
     */
    public void sortStreets(){
        Collections.sort(streetList,Comparator.comparing(Street::getLength));
    }

    /**
     * Stores the street with the two intersections connected to it
     * @param street
     * @param intersection1
     * @param intersection2
     */
    public void addAssociatedIntersection(Street street, Intersection intersection1, Intersection intersection2){
        List<Intersection> intersections= new ArrayList<>();
        intersections.add(intersection1);
        intersections.add(intersection2);
        streetWithIntersections.put(street,intersections);
    }

    /**
     * Display the streets that intersect at least 3 other streets, and have length greater than a value
     * @param value The value compared to the length of the street
     */
    public void displayLongerStreets(int value){
        System.out.println("\nStreets with longer lengths and that join at least 3 streets:");
        for(Street street : streetList){
            int adjacentStreets=-1;
            boolean isGreater=false;
            if(street.getLength() > value) {
                isGreater = true;
            }

            for(Street street1:streetList){
                List<Intersection> common = new ArrayList<>(streetWithIntersections.get(street1));
                common.retainAll(streetWithIntersections.get(street));
                if(!common.isEmpty())
                    adjacentStreets+=1;
            }

            if(isGreater==true && adjacentStreets > 2) {
                System.out.println(street);
            }
        }
    }

    /**
     * Using the hashset, the list and the map from the current class, creates the input (adds vertexes and edges).
     * Calculates the minimum spanning tree using Kruskal's algorithm
     */
    public void calculateMinimumPath(){
        DefaultUndirectedGraph<String, DefaultEdge> g = new DefaultUndirectedGraph<>(DefaultEdge.class);

        for(Intersection intersection:intersectionSet){
            g.addVertex(intersection.getName());
        }

        for(Street street:streetList){
            g.addEdge(streetWithIntersections.get(street).get(0).getName(),
                    streetWithIntersections.get(street).get(1).getName());
        }

        KruskalMinimumSpanningTree<String, DefaultEdge> graph2 = new KruskalMinimumSpanningTree<>(g);
        System.out.println(graph2.getSpanningTree());
    }

    @Override
    public String toString() {
        return "Solution{" +
                "streetList=" + streetList + '\n' +
                ", intersectionSet=" + intersectionSet + '\n' +
                '}';
    }
}
