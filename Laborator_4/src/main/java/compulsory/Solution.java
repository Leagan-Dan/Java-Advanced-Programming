package compulsory;

import java.util.*;

public class Solution {
    private List<Street> streetList = new LinkedList<>();
    private Set<Intersection> intersectionSet = new HashSet<>();
    private Map <Street, List<Intersection>> streetWithIntersections= new HashMap<>();

    public Solution() {
    }

    //returneaza map-ul care retine ce intersectii corespund fiecarei strazi
    public Map<Street, List<Intersection>> getStreetWithIntersections() {
        return streetWithIntersections;
    }

    public void addStreet(Street o){
        streetList.add(o);
    }

    public void addIntersection(Intersection o){
        intersectionSet.add(o);
    }

    //afiseaza pe ecran hashset-ul cu strazile
    public void printIntersectionSet(){
        for(Intersection intersection:intersectionSet){
            System.out.println(intersection.getName());
        }
    }
    //sorteaza strazile folosindu-se de metoda compareTo, care este overridden
    public void sortStreets(){
        Collections.sort(streetList,Comparator.comparing(Street::getLength));
    }

    //completeaza map-ul care retine intersectiile asociate fiecarei strazi
    public void addAssociatedIntersection(Street street, Intersection intersection1, Intersection intersection2){
        List<Intersection> intersections= new ArrayList<>();
        intersections.add(intersection1);
        intersections.add(intersection2);
        streetWithIntersections.put(street,intersections);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "streetList=" + streetList + '\n' +
                ", intersectionSet=" + intersectionSet + '\n' +
                '}';
    }
}
