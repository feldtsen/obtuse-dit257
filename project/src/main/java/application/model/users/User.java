package application.model.users;

import application.model.posts.IPost;
import application.model.util.PhoneNumber;

import java.util.List;
import java.util.ArrayList;

public class User implements IUser{
    private final String name;
    private final String address;
    private final PhoneNumber phoneNumber;

    public User(String name, String address, PhoneNumber phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }
}
