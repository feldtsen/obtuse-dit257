package model.post;
import application.model.posts.IItem;
import application.model.posts.Request;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RequestTest {

    @Test
    public void testOfferUnsatisfied(){

        IUser u1 = null;
        IUser u2 = null;
        try {
            u1 = new User("Oom", new PhoneNumber("0738400612"));
            u2 = new User("Joachim", new PhoneNumber("0738400612"));
        } catch (InvalidPhoneNumberException ignored) {
            fail();
        }

        List<IItem> items = new ArrayList<>();

        Request r1 = new Request("äpple", "Vill ha grönt äpple", u1, items);

        r1.offer(u2);

        assertTrue(r1.getIsSatisfied());

    }

    @Test
    public void testOfferSatisfied(){

        IUser u1 = null;
        IUser u2 = null;
        IUser u3 = null;
        try {
            u1 = new User("Oom", new PhoneNumber("0738400612"));
            u2 = new User("Joachim", new PhoneNumber("0738400612"));
            u3 = new User("Anton", new PhoneNumber("0738400612"));
        } catch (InvalidPhoneNumberException e) {
            fail();
        }

        List<IItem> items = new ArrayList<>();

        Request r1 = new Request("äpple", "Vill ha grönt äpple", u1, items);

        r1.offer(u2);

        assertFalse(r1.offer(u2));

    }

    @Test
    public void testOfferOwnRequest(){

        IUser u1 = null;
        try {
            u1 = new User("Oom", new PhoneNumber("0738400612"));
        } catch (InvalidPhoneNumberException e) {
            fail();
        }

        List<IItem> items = new ArrayList<>();

        Request r1 = new Request("äpple", "Vill ha grönt äpple", u1, items);

        assertFalse(r1.offer(u1));

    }

}
