package application.model.users;

import application.model.util.PhoneNumber;

public class User implements IUser{
    private final String name;
    private final PhoneNumber phoneNumber;

    public User(String name, PhoneNumber phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }

}
