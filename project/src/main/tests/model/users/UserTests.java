package model.users;

import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTests {

    private User ashor;

    {
        try {
            ashor = new User("Ashor.k", "Where he lives", new PhoneNumber("0737266506"), "123");
        } catch (InvalidPhoneNumberException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNameTest(){
        assertEquals("Ashor.k", ashor.getName());
    }

    @Test
    public void getPhoneNumberTest(){
        assertEquals("0737266506", ashor.getPhoneNumber().toString());
    }

    @Test
    public void getAddressTest() {
        assertEquals("Where he lives", ashor.getAddress());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("123", ashor.getPassword());
    }
}
