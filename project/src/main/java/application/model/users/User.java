package application.model.users;

import application.model.util.PhoneNumber;

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
    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }

}
