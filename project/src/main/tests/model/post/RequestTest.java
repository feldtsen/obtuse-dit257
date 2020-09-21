package model.post;
import application.model.posts.IItem;
import application.model.posts.Request;
import application.model.users.IUser;
import application.model.users.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RequestTest {

    @Test
    public void testOfferUnsatisfied(){

        IUser u1 = new User("Oom", "0738400612");
        IUser u2 = new User("Joachim", "0738400612");

        List<IItem> items = new ArrayList<>();

        Request r1 = new Request("äpple", "Vill ha grönt äpple", u1, items);

        r1.offer(u2);

        assertTrue(r1.getIsSatisfied());

    }

    @Test
    public void testOfferSatisfied(){

        IUser u1 = new User("Oom", "0738400612");
        IUser u2 = new User("Joachim", "0738400612");
        IUser u3 = new User("Anton", "0738400612");

        List<IItem> items = new ArrayList<>();

        Request r1 = new Request("äpple", "Vill ha grönt äpple", u1, items);

        r1.offer(u2);

        assertFalse(r1.offer(u2));

    }

    @Test
    public void testOfferOwnRequest(){

        IUser u1 = new User("Oom", "0738400612");

        List<IItem> items = new ArrayList<>();

        Request r1 = new Request("äpple", "Vill ha grönt äpple", u1, items);

        assertFalse(r1.offer(u1));

    }

}
