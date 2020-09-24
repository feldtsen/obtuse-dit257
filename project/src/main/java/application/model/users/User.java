package application.model.users;

import application.model.util.PhoneNumber;

public class User implements IUser{
    private final String name;
    private final PhoneNumber phonenumber;

    public User(String name, PhoneNumber phonenumber){
        this.name = name;
        this.phonenumber = phonenumber;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public PhoneNumber getPhoneNumber(){
        return phonenumber;
    }

}
