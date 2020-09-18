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

        IUser u1 = new User("user1", "0738400612");
        IUser u2 = new User("user2", "0738400612");

        List<IItem> items = new ArrayList<>();

        Donation p1 = new Donation("äpple", "frukt", u1, items);

        p1.claim(u2);

        assertTrue(p1.isClaimed());

    }

    @Test
    public void testClaimClaimed(){

        IUser u1 = new User("user1", "0738400612");
        IUser u2 = new User("user2", "0738433312");
        IUser u3 = new User("user3", "0738444412");

        List<IItem> items = new ArrayList<>();

        Donation p1 = new Donation("äpple", "frukt", u1, items);

        p1.claim(u2);
        p1.claim(u3);

        assertTrue(p1.getClaimedBy() == u2 && p1.getClaimedBy() != u3);

    }

    @Test
    public void testClaimOwnPost(){

        IUser u1 = new User("user1", "0738400612");
        IUser u2 = new User("user2", "0738400222");

        List<IItem> items = new ArrayList<>();

        Donation p1 = new Donation("äpple", "frukt", u1, items);

        p1.claim(u1);

        assertFalse(p1.isClaimed());

    }

}
