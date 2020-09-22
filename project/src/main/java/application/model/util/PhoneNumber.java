package application.model.util;

public class PhoneNumber {
    private final String number;

    public PhoneNumber(String number) throws InvalidPhoneNumberException {
        if(!isValidNumber(number)) throw new InvalidPhoneNumberException(number + " is not a valid phone number.");
        this.number = number;
    }

    private boolean isValidNumber(String number) {

        return true;
    }

    public String getNumber() {
        return number;
    }
}
