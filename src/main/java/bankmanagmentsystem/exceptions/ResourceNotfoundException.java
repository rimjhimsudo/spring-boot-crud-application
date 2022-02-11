package bankmanagmentsystem.exceptions;

//class specific to exception ResourceNotfoundException
/*
we can create more classes like this and customise
 */
public class ResourceNotfoundException extends Exception {

    public ResourceNotfoundException() {
    }

    public ResourceNotfoundException(String message) {
        super(message);
    }
}
