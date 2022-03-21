package homework;

import com.github.javafaker.Faker;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Solution solution= new Solution();

        Faker faker = new Faker();

        Intersection[] intersections = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection(faker.address().streetName()))
                .toArray(Intersection[]::new);

        for(Intersection intersection : intersections){
            solution.addIntersection(intersection);
        }

        Street street1 = new Street(faker.address().streetName() + 1, 1);
        Street street2 = new Street(faker.address().streetName() + 2, 2);
        Street street3 = new Street(faker.address().streetName() + 3, 3);
        Street street4 = new Street(faker.address().streetName() + 4, 2);

        solution.addStreet(street1);
        solution.addStreet(street2);
        solution.addStreet(street3);
        solution.addStreet(street4);


        solution.addAssociatedIntersection(street1, intersections[0], intersections[1]);
        solution.addAssociatedIntersection(street2, intersections[1], intersections[2]);
        solution.addAssociatedIntersection(street3, intersections[2], intersections[3]);
        solution.addAssociatedIntersection(street4, intersections[1], intersections[3]);


        solution.sortStreets();
        System.out.println(solution);
        solution.printIntersectionSet();
        System.out.println(solution.getStreetWithIntersections());
        solution.displayLongerStreets(1);
        solution.calculateMinimumPath();

    }
}
