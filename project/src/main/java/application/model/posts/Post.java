package application.model.posts;

import application.model.users.IUser;

import java.util.List;

public abstract class Post implements IPost {

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
