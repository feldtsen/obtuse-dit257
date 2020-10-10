package application.model.posts;

import application.model.users.IUser;

import java.util.Set;
import java.util.UUID;
import java.util.HashSet;

public class Post implements IPost {

    private String uniqueID;
    private final String title;
    private final String description;
    private final IUser author;
    private final String postType;
    private final Set<String> tags;
    //private final String imagePath;
    // TODO: implement private final ImageContainer image;


    public Post(String title, String description, IUser author, String postType, Set<String> tags) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.uniqueID = UUID.randomUUID().toString();
        this.postType = postType;
        this.tags = new HashSet<>(tags);
    }


    @Override
    public String getUniqueID() {
        return this.uniqueID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public IUser getAuthor() {
        return author;
    }

    @Override
    public String getPostType() {
        return postType;
    }
/*
    @Override
    public Range getAvailableTime() {
        return null;
    }
*/

    @Override
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

  /*  @Override
    public ImageView getImage() {
        return image;
    }

    @Override
    public void setImage(ImageView image) {

    }
*/
    @Override
    public Set<String> getTags() {
        return tags;
    }
}
