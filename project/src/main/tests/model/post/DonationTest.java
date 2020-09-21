package model.post;

import static org.junit.Assert.*;
import application.model.posts.Donation;
import application.model.posts.IItem;
import application.model.posts.IPost;
import application.model.posts.Post;
import application.model.users.IUser;
import application.model.users.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DonationTest {

    @Test
    public void testClaimUnclaimed(){

        IUser u1 = new User("Oom", "0738400612");
        IUser u2 = new User("Joachim", "0738400612");

        List<IItem> items = new ArrayList<>();

        Donation d1 = new Donation("äpple", "frukt", u1, items);

        d1.claim(u2);

        assertTrue(d1.isClaimed());

    }

    @Test
    public void testClaimClaimed(){

        IUser u1 = new User("Oom", "0738400612");
        IUser u2 = new User("Joachim", "0738433312");
        IUser u3 = new User("Anton", "0738444412");

        List<IItem> items = new ArrayList<>();

        Donation d1 = new Donation("äpple", "frukt", u1, items);

        d1.claim(u2);
        d1.claim(u3);

        assertTrue(d1.getClaimedBy() == u2 && d1.getClaimedBy() != u3);

    }

    @Test
    public void testClaimOwnPost(){

        IUser u1 = new User("Oom", "0738400612");

        List<IItem> items = new ArrayList<>();

        Donation d1 = new Donation("äpple", "frukt", u1, items);

        d1.claim(u1);

        assertFalse(d1.isClaimed());

    }

}
