package application.model.posts;

import application.model.users.IUser;

import java.io.Serializable;
import java.util.List;

public interface IPost extends Serializable {
    String getUUID();
    String getTitle();
    String getDescription();
    String getPostType();

    List<IItem> getItems();
    IUser getAuthor();
    //Range getAvailableTime();
}
