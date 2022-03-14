package compulsory;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Solution solution= new Solution();

        Intersection[] intersections = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("intersection" + i))
                .toArray(Intersection[]::new);

        for(Intersection intersection : intersections){
            solution.addIntersection(intersection);
        }


        Street street1 = new Street("street1", 1);
        Street street2 = new Street("street2", 1);
        Street street3 = new Street("street3", 2);
        Street street4 = new Street("street4", 1);
        Street street5 = new Street("street6", 3);
        solution.addStreet(street1);
        solution.addStreet(street2);
        solution.addStreet(street3);
        solution.addStreet(street4);
        solution.addStreet(street5);


        solution.addAssociatedIntersection(street1, intersections[0], intersections[1]);
        solution.addAssociatedIntersection(street2, intersections[1], intersections[2]);
        solution.addAssociatedIntersection(street3, intersections[2], intersections[3]);
        solution.addAssociatedIntersection(street4, intersections[1], intersections[3]);

        solution.sortStreets();
        System.out.println(solution);
        solution.printIntersectionSet();
        System.out.println(solution.getStreetWithIntersections());

    }
}
