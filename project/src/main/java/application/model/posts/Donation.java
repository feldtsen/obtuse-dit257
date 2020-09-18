package application.model.posts;

import application.model.users.IUser;

import java.util.List;

public class Donation extends Post {

    private boolean claimed;
    private IUser claimedBy;
    private boolean received;

    public Donation(String title, String description, IUser author, List<IItem> items) {
        super(title, description, author, items);
        this.claimed = false;
        this.claimedBy = null;
    }

    public boolean claim(IUser user) {
        if(isClaimed() || user == getAuthor()) return false;
        this.claimed = true;
        this.claimedBy = user;
        return true;
    }
    public void setReceived(){received = true;}
    public boolean isClaimed(){return claimed;}
    public boolean isReceived() {
        return received;
    }
    public IUser getClaimedBy(){return claimedBy;}

}
