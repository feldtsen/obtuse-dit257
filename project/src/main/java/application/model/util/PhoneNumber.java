package application.model.util;

import java.util.regex.Pattern;

public class PhoneNumber {
    private final static String VALID_PATTERNS
            = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

    private final String number;

    public PhoneNumber(String number) throws InvalidPhoneNumberException {
        if(!isValidNumber(number)) throw new InvalidPhoneNumberException(number + " is not a valid phone number.");
        this.number = number;
    }

    private boolean isValidNumber(String number) {
        Pattern pattern = Pattern.compile(VALID_PATTERNS);
        return pattern.matcher(number).matches();
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}