package homework;


public class Solution {
    private Instance instance;

    /**
     * This constructor creates an object that will solve the problem based on the instance.
     * @param instance The set of rooms and events given by the problem
     */
    public Solution(Instance instance) {
        this.instance = instance;
    }

    /**
     * This method implements an algorithm for deciding which Rooms will be assigned to which objects. For every room,
     * the algorithm assigns as many events that were not already assigned, as possible,
     * taking place at different time. If there are no events left, the algorithm stops.
     */
    public void solve() {
        System.out.println("Solution:");

        int eventsAssigned = 0;
        for (int index = 0; index < instance.getRooms().size(); index++) {
            if (eventsAssigned > instance.getEvents().size())
                break;
            int indexEvents = 0;
            int lastEndTime = 0;
            while (indexEvents < instance.getEvents().size()) {
                if (instance.getEvents().get(indexEvents).getSize() <= instance.getRooms().get(index).getCapacity()) {
                    if (lastEndTime <= instance.getEvents().get(indexEvents).getStartTime())
                        if (!instance.getEvents().get(indexEvents).isAssigned()) {
                            System.out.println(instance.getEvents().get(indexEvents).getName() + " - " +
                                    instance.getRooms().get(index).getName());
                            instance.getEvents().get(indexEvents).setAssigned(true);
                            eventsAssigned++;
                            lastEndTime = instance.getEvents().get(indexEvents).getEndTime();
                        }
                }
                indexEvents++;
            }
        }
    }
}
