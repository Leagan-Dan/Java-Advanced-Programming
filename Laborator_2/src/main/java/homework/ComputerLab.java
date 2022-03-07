package homework;


public class ComputerLab extends Room {
    private String operatingSystem;


    public ComputerLab(String operatingSystem, String name, int capacity) {
        super(name, capacity);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
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
        ComputerLab that = (ComputerLab) o;
        return that.getCapacity() == super.getCapacity() && that.getName().equals(super.getName())
                && operatingSystem.equals(that.operatingSystem);
    }

    /**
     * This method overrides the toString method in order to print an object.
     * @return The attributes that will be printed
     */
    @Override
    public String toString() {
        return "ComputerLab{" +
                "operatingSystem='" + operatingSystem + '\'' +
                ", name='" + super.getName() + '\'' +
                ", capacity=" + super.getCapacity() +
                '}'  + '\n';
    }
}
