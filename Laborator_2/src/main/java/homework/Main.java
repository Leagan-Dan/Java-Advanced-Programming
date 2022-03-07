package homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Event c1 = new Event("C1", 100, 8, 10);
        Event c2 = new Event("C2", 100, 10, 12);
        Event l1 = new Event("L1", 30, 8, 10);
        Event l2 = new Event("L2", 30, 8, 10);
        Event l3 = new Event("L3", 30, 10, 12);

        ComputerLab computerLab = new ComputerLab("Linux", "401", 30);
        ComputerLab computerLab2 = new ComputerLab("Linux", "403", 30);
        ComputerLab computerLab3 = new ComputerLab("Linux", "405", 30);
        LectureHall lectureHall = new LectureHall("309", 100, true);
        LectureHall lectureHall1 = new LectureHall("309", 100, true);

        Instance instance = new Instance();

        instance.addEvent(c1);
        instance.addEvent(c2);
        instance.addEvent(l1);
        instance.addEvent(l2);
        instance.addEvent(l3);
        instance.addRoom(computerLab);
        instance.addRoom(computerLab2);
        instance.addRoom(computerLab3);
        instance.addRoom(lectureHall);
        instance.addRoom(lectureHall1);
        System.out.println(instance);

        Solution solution = new Solution(instance);
        solution.solve();
    }
}
