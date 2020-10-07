package application.model.posts;

import application.model.users.IUser;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.List;

public interface IPost extends Serializable {
    String getUniqueID();
    String getTitle();
    String getDescription();
    String getPostType();

    List<IItem> getItems();
    IUser getAuthor();
    //Range getAvailableTime();
    void setUniqueID(String uniqueID);
    //ImageView getImage();
    //void setImage(ImageView image);
    List<String> getTags();
}
