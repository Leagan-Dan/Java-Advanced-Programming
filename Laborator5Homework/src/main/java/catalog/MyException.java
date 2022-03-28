package catalog;

public class MyException extends RuntimeException{

    /**
     * Exception for items with id already in use
     */
    public MyException(int id) {
        super("id " + id + " already in use");
    }

}
