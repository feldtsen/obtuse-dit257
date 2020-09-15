package application.model.users;

import application.model.posts.IPost;
import java.util.List;
import java.util.ArrayList;

public class User implements IUser{
    private String name;
    private String phoneNumber;

    public User(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
