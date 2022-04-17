package game;

public class NotAlphabeticException extends Exception{
    public NotAlphabeticException(){
        super("One or more of the characters are not letters");
    }
}
