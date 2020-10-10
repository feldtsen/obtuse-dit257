package application.model.posts;

import application.model.users.IUser;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IPost extends Serializable {
    String getUniqueID();
    String getTitle();
    String getDescription();
    String getType();

    String getImagePath();

    IUser getAuthor();
    void setUniqueID(String uniqueID);
    Set<String> getTags();
}
