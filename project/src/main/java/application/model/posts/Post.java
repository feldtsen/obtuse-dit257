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
    private final String type;
    private final Set<String> tags;
    private final String imagePath;

    public Post(String title, String description, IUser author, String type, Set<String> tags, String imagePath) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.uniqueID = UUID.randomUUID().toString();
        this.type = type;
        this.tags = new HashSet<>(tags);
        this.imagePath = imagePath;
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
    public String getType() {
        return type;
    }

    @Override
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public Set<String> getTags() {
        return tags;
    }
}
