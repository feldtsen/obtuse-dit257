package application.model.users;

import application.model.util.PhoneNumber;

import java.io.Serializable;

public interface IUser extends Serializable {
    String getName();
    String getAddress();
    PhoneNumber getPhoneNumber();
    String getPassword();
}
