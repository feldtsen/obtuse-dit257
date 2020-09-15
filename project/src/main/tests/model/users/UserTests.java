package model.users;

import application.model.users.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTests {

    private User ashor = new User("Ashor.k", "0737266506");

    @Test
    public void getNameTest(){
        assertEquals("Ashor.k", ashor.getName());
    }

    @Test
    public void getPhonenumberTest(){
        assertEquals("0737266506", ashor.getPhoneNumber());
    }
}
