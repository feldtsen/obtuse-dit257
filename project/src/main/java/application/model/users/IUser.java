package application.model.users;

import application.model.util.PhoneNumber;

import java.io.Serializable;

// This class represents the user of the application
public interface IUser extends Serializable {
    // The real name or alias of the user
    String getName();

    // The address of the user. This field is useful when creating posts, to show where
    // the contents of a post can be picked up or left off.
    String getAddress();

    // The phone number of the user. This is required to give users a way of interacting.
    PhoneNumber getPhoneNumber();

    // The password of the user.
    String getPassword();
}
