package application.model.posts;

import application.model.users.IUser;

import java.util.List;

public interface IPost {
    String getTitle();
    String getDescription();

    List<IItem> getItems();
    IUser getAuthor();
    //Range getAvailableTime();
}
