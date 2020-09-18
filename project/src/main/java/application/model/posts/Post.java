package application.model.posts;

import application.model.users.IUser;

import java.util.List;

public abstract class Post implements IPost {

    private final String title;
    private final String description;
    private final IUser author;
    private final List<IItem> items;
    //private final Range Availabletime;
    private IUser claimedBy;
    private boolean claimed;
    private boolean received;

    public Post(String title, String description, IUser author, List<IItem> items) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.items = items;
        this.claimed = false;
        this.received = false;
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
    @Override
    public boolean isClaimed() {
        return claimed;
    }

    @Override
    public boolean isReceived() {
        return received;
    }

    @Override
    public boolean claim(IUser user) {
        if(isClaimed() || user == author) return false;
        this.claimed = true;
        this.claimedBy = user;
        return true;
    }
}
