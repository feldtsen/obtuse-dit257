package model.util;

import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneNumberTest {

    @Test
    public void testValidPhoneNumbers() {
        String[] validPhoneNumbers
                = {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
                "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89",
                "0738400612", "073-8400612", "073 8400612", "+46738400612"};

        for(String pn : validPhoneNumbers) {
            try {
                new PhoneNumber(pn);
            } catch (InvalidPhoneNumberException e) {
                fail();
            }
        }
        assertTrue(true);
    }

    @Test
    public void testInvalidPhoneNumbers() {
        String[] validPhoneNumbers
                = {"205a550125","2102 555 0125", ")202) 555-0125", "-111 (202) 555-0125",
                "636--856 789", "+111 636 856 78911", "63 6 8 5 6 7 8 9", "+111 636 85_67 89"};

        for(String pn : validPhoneNumbers) {
            try {
                new PhoneNumber(pn);
                fail();
            } catch (InvalidPhoneNumberException ignored) {
            }
        }
        assertTrue(true);
    }
}
