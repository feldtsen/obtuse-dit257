package application.model.posts;

import application.model.users.IUser;

public abstract class Post implements IPost {

    private final String title;
    private final String description;
    private final IUser user;
    private final IItem item;
    //private final Range Availabletime;
    private boolean claimed;
    private boolean received;

    public Post(String title, String description, IUser user, IItem item) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.item = item;
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
    public IItem getItem() {
        return item;
    }

    @Override
    public IUser getUser() {
        return user;
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
        // TODO
        return false;
    }
}
