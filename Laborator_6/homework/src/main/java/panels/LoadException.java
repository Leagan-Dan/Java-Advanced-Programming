package panels;

public class LoadException extends Exception {
    public LoadException(){
        super("The chosen file does not exist");
    }
}
