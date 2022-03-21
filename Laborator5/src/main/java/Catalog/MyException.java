package Catalog;

public class MyException extends RuntimeException{

    public MyException(int id) {
        super("id " + id + " already in use");
    }

}
