package application.model.posts;

import application.model.users.IUser;

public interface IPost {
    String getTitle();
    IItem getItem();
    IUser getUser();
    //Range getAvailableTime();
    boolean claim(IUser user);
    boolean isClaimed();
    boolean isReceived();
}
