package application.model.posts;

import application.model.users.IUser;

import java.util.List;

public class Request extends Post{

    public Request(String title, String description, IUser user, List<IItem> items) {
        super(title, description, user, items);
    }
}
