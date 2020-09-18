package application.model.posts;

import application.model.users.IUser;

import java.util.List;

public class Donation extends Post {
    public Donation(String title, String description, IUser user, List<IItem> items) {
        super(title, description, user, items);
    }
}
