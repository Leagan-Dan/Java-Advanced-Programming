package compulsory;

public class Main {
    public static void main(String[] args) {
        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);
        Room R401 = new Room("401", Type.LAB, 30);
        Room R403 = new Room("403", Type.LAB, 30);
        Room R405 = new Room("405", Type.LAB, 30);
        Room R309 = new Room("309", Type.LECTURE_HALL, 100);

        System.out.println("Events:");
        System.out.println(C1.toString()
                + C2.toString()
                + L1.toString()
                + L2.toString()
                + L3.toString());

        System.out.println("Rooms:");
        System.out.println(R309.toString()
                + R401.toString()
                + R403.toString()
                + R405.toString());
    }
}
