package application.model.posts;

import application.model.users.IUser;

import java.io.Serializable;
import java.util.Set;

// IPost is the interface used by the Post class
// Extends Serializable for the functionality of saving in a .ser file
public interface IPost extends Serializable {

    // Returns a post's uniqueID
    String getUniqueID();

    // Returns a post's title
    String getTitle();

    // Returns a post's description
    String getDescription();

    // Returns a post's type. Is Either "Donation" or "Request"
    String getType();

    // Returns the image-path used by the image in the post
    String getImagePath();

    // Returns the author/user who created the post
    IUser getAuthor();

    // Used when a post is edited so that the edited post (which creates a new post) contains the same uniqueID as before
    void setUniqueID(String uniqueID);

    // Returns tags on the post. Used for filtering and categorisation of posts.
    Set<String> getTags();
}
