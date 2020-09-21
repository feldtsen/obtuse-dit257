package application.model.posts;

import application.model.users.IUser;

import java.util.ArrayList;
import java.util.List;

public class Request extends Post{

    private boolean isSatisfied;
    private boolean isReceived;
    private final List<IUser> donators;

    public Request(String title, String description, IUser author, List<IItem> items) {
        super(title, description, author, items);
        this.isSatisfied = false;
        this.isReceived = false;
        this.donators = new ArrayList<>();
    }

    public boolean getIsSatisfied(){return isSatisfied;}
    public boolean getIsReceived(){return isReceived;}
    public List<IUser> getDonator(){return donators;}

    public boolean offer(IUser donator){
        // Todo: change implementation to be able to have multiple items
        if(isSatisfied || donator == getAuthor()){return false;}
        donators.add(donator);
        this.isSatisfied = true;
        return true;
    }

}
