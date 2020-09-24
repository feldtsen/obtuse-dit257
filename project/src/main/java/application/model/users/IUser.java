package application.model.users;

import application.model.util.PhoneNumber;

public interface IUser {
    String getName();
    String getAddress();
    PhoneNumber getPhoneNumber();
}
