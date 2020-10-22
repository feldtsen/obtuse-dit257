package application.model.util;

// Exception which is thrown when an invalid phone number is entered
public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
