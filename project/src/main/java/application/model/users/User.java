package application.model.users;

import application.model.posts.IPost;
import java.util.List;
import java.util.ArrayList;

public class User implements IUser{
    @Override
    public String getName(){
        return "";
    }

    @Override
    public String phoneNumber(){
        return "";
    }

    @Override
    public List<IPost> getPosts(){
        return new ArrayList<>();
    }
}
