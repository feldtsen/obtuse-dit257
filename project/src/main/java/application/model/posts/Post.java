package application.model.posts;

import application.model.users.IUser;

import java.util.Set;
import java.util.UUID;
import java.util.HashSet;

// The post class is responsible for containing the attributes used when creating and reading a post.
// A post is either a "Request" or a "Donation"
public class Post implements IPost {

    // Used to differentiate posts
    private String uniqueID;
    // The title for the post
    private final String title;
    // The description of the post
    private final String description;
    // The author of the post
    private final IUser author;
    // Is either "Donation" or "Request"
    private final String type;
    // The set of tags for the post. Used to filter posts.
    private final Set<String> tags;
    // The path for the image in post. If null, no image is displayed
    private final String imagePath;

    // Constructor for Post. imagePath can be null
    public Post(String title, String description, IUser author, String type, Set<String> tags, String imagePath) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.uniqueID = UUID.randomUUID().toString();
        this.type = type;
        this.tags = new HashSet<>(tags);
        this.imagePath = imagePath;
    }

    // Returns a post's uniqueID
    @Override
    public String getUniqueID() {
        return this.uniqueID;
    }

    // Returns a post's title
    @Override
    public String getTitle() {
        return title;
    }

    // Returns a post's description
    @Override
    public String getDescription() {
        return description;
    }

    // Returns the author/user who created the post
    @Override
    public IUser getAuthor() {
        return author;
    }

    // Returns a post's type. Is Either "Donation" or "Request"
    @Override
    public String getType() {
        return type;
    }

    // Used when a post is edited so that the edited post (which creates a new post) contains the same uniqueID as before
    @Override
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    // Returns the image-path used by the image in the post
    @Override
    public String getImagePath() {
        return imagePath;
    }

    // Returns tags on the post. Used for filtering and categorisation of posts.
    @Override
    public Set<String> getTags() {
        return tags;
    }
}
