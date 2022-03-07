package homework;


import java.util.ArrayList;
import java.util.List;

public class Instance {
    private List<Event> events = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public Instance() {
    }

    public Instance(List<Event> events, List<Room> rooms) {
        this.events = events;
        this.rooms = rooms;
    }

    /**
     * This method returns the list of events.
     * @return the list of events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * This method replaces the list of events with another one.
     * @param events The list of event that will replace the current one
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * This method returns the list of rooms.
     * @return the list of rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * This method replaces the list of rooms with another one.
     * @param rooms The list of rooms that will replace the current one
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * This method adds an event to the instance of the problem.
     *
     * @param event The event which will he added
     */
    public void addEvent(Event event) {
        boolean adauga = true;
        for (int index = 0; index < events.size(); index++) {
            if (event.equals(events.get(index))) {
                adauga = false;
            }
        }
        if (adauga)
            events.add(event);
    }

    /**
     * This method adds a room to the list of rooms, checking if the room already exists.
     * @param room The room that will be added
     */
    public void addRoom(Room room) {
        boolean adauga = true;
        for (int index = 0; index < rooms.size(); index++) {
            if (room.equals(rooms.get(index))) {
                adauga = false;
            }
        }
        if (adauga)
            rooms.add(room);
    }

    /**
     * This method overrides the toString method in order to print an object.
     * @return The attributes that will be printed
     */
    @Override
    public String toString() {
        return "Instance{" +
                "events=" + events +
                ", rooms=" + rooms +
                '}';
    }
}
