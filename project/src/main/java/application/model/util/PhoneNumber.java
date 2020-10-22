package application.model.util;

import java.io.Serializable;
import java.util.regex.Pattern;

// Class representing phone numbers of users
public class PhoneNumber implements Serializable {
    // Regex for matching valid phone numbers
    private final static String VALID_PATTERNS
            = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

    // The actual phone number
    private final String number;

    public PhoneNumber(String number) throws InvalidPhoneNumberException {
        // Throw exception if phone number is invalid
        if(!isValidNumber(number)) throw new InvalidPhoneNumberException(number + " is not a valid phone number.");
        this.number = number;
    }

    // Validate phone number
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
