package homework;

public interface Storage {
    long getStorageCapacity();

    default String getConvertedStorageCapacity() {
        return this.getStorageCapacity() * 1024 + " megabytes\n" +
                this.getStorageCapacity() * 1024 * 1024 + " kilobytes\n" +
                this.getStorageCapacity() * 1024 * 1024 * 1024 + " bytes\n";
    }
}
