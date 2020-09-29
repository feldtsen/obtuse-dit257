package application.model.posts;

import application.model.users.IUser;

import java.util.List;
import java.util.UUID;

public abstract class Post implements IPost {

    private final String uniqueID;
    private final String title;
    private final String description;
    private final IUser author;
    private final List<IItem> items;
    //private final Range Availabletime;

    public Post(String title, String description, IUser author, List<IItem> items) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.items = items;
        this.uniqueID = UUID.randomUUID().toString();
    }
    public Post(String title, String description, IUser author, List<IItem> items, String uuid) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.items = items;
        this.uniqueID = uuid;

    }

    @Override
    public String getUUID() {
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
    public List<IItem> getItems() {
        return items;
    }

    @Override
    public IUser getAuthor() {
        return author;
    }
/*
    @Override
    public Range getAvailableTime() {
        return null;
    }
*/





}
