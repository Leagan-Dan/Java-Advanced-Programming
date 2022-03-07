package homework;
import java.util.Objects;

public class LectureHall extends Room {
    private boolean videoProjector;

    public LectureHall() {
    }

    public LectureHall(String name, int capacity, boolean videoProjector) {
        super(name, capacity);
        this.videoProjector = videoProjector;
    }

    public boolean isVideoProjector() {
        return videoProjector;
    }

    public void setVideoProjector(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    /**
     * This method overrides the method equals in order to compare two objects by their attributes.
     * @param o The object that will be compared with the current one
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureHall that = (LectureHall) o;
        return that.getCapacity() == super.getCapacity() && that.getName().equals(super.getName())
                && videoProjector == that.videoProjector;
    }

    /**
     * This method overrides the toString method in order to print an object.
     * @return The attributes that will be printed
     */
    @Override
    public String toString() {
        return "LectureHall{" +
                "videoProjector=" + videoProjector +
                ", name='" + super.getName() + '\'' +
                ", capacity=" + super.getCapacity() +
                '}' + '\n';
    }

}
