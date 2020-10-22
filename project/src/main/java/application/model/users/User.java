package application.model.users;

import application.model.util.PhoneNumber;

// A class representing the user of the application.
// Class is described in the comments to the IUser interface.
public class User implements IUser {
    private final String name;
    private final String address;
    private final PhoneNumber phoneNumber;
    private final String password;

    public User(String name, String address, PhoneNumber phoneNumber, String password){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
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

    @Override
    public String getPassword() { return password; }
}
