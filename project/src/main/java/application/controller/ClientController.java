package application.controller;

import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.FileIO;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import application.ResourceLoader;
import application.model.client.TagParser;
import application.view.navigation.RegisterNavigationButton;
import application.view.pages.PageParent;
import application.view.pages.login.RegisterPage;
import application.view.status.AlertBannerModule;
import application.view.status.LoginBannerModule;
import application.view.status.LogoutButton;
import javafx.scene.control.Alert;

import java.io.*;

public class ClientController {
    public static void init() {
        loadFromDisk();
    }

    public static void handleLogin(String phone, String password) {
        String path = createUserFilePath(phone);
        File file = new File(path);
        if(file.exists()) {
            IUser currentUser= loadUser(file.getPath());
            if (currentUser.getPassword().equals(password)) {
                loginUser(loadUser(path));
            }
            else {
                showAlert("Wrong password", Alert.AlertType.ERROR);
                return;
            }
        } else {
            showAlert("Please register or type the correct username", Alert.AlertType.ERROR);
        }
    }

    private static void loginUser(IUser user) {
        Client.getInstance().setUser(user);
        LoginBannerModule.getInstance().setLoggedInAs(user.getName());
        showAlert("Login successful as " + user.getName(), Alert.AlertType.CONFIRMATION);
        LogoutButton.getInstance().setWhenLoggedInText();
    }

    public static void handleLogout() {
        //TODO
        IClient client = Client.getInstance();
        IUser user = client.getUser();
        if (user==null) {
            showAlert("No user is logged in", Alert.AlertType.ERROR);
            return;
        }
        showAlert(user.getName()+" is logged out", Alert.AlertType.CONFIRMATION);
        client.setUser(null);
        LoginBannerModule.getInstance().setNotLoggedIn();
        LogoutButton.getInstance().setWhenLoggedOutText();
        PageParent.loadPage(RegisterPage.getInstance(), RegisterNavigationButton.getInstance());

    }

    public static void handleRegisterButton(String name, String address, String phoneNumber, String password) {

        if (name.equals("")) {
            showAlert( "Name field must be filled", Alert.AlertType.ERROR);
            return;
        }

        if (address.equals("")) {
            showAlert("Address field must be filled", Alert.AlertType.ERROR);
            return;
        }

        if (password.equals("")) {
            showAlert("Password field must be filled", Alert.AlertType.ERROR);
            return;
        }

        // If the user already exist, do not register anew
        if(new File(createUserFilePath(phoneNumber)).exists()) {
            showAlert("A user with the phone number " + phoneNumber + " already exists.", Alert.AlertType.ERROR);
            return;
        }

        IUser user;
        try {
            user = createUser(name, address, phoneNumber, password);
            FileIO.saveObject(user, createUserFilePath(user));
            showAlert("You have been registered successfully", Alert.AlertType.CONFIRMATION);
        } catch (InvalidPhoneNumberException e) {
            showAlert("Your phone number format is invalid", Alert.AlertType.ERROR);
            return;
        } catch (IOException e) {
            showAlert("The user couldn't be saved! Check file path and try again!", Alert.AlertType.ERROR);
            return;
        }
        // Automatically login registered user
        loginUser(user);
    }

    /**
     * Create a user
     *
     * @param name        the name of the user
     * @param address     the address of the user
     * @param phoneNumber the phone number of the user
     * @return a new user object, or a stored one if already exists
     * @throws InvalidPhoneNumberException if the phone number is invalid
     */
    public static IUser createUser(String name, String address, String phoneNumber, String password) throws InvalidPhoneNumberException {
        String userFilePath = createUserFilePath(phoneNumber);
        File userFile = new File(userFilePath);
        if (userFile.exists()) {
            return loadUser(userFilePath);
        }
        // Create user directory if it does not exist
        File userDir = new File(ResourceLoader.usersDir);
        if(!userDir.exists()) {
            userDir.mkdirs();
        }

        PhoneNumber phone = new PhoneNumber(phoneNumber);
        return new User(name, address, phone, password);
    }

    private static String createUserFilePath(IUser user) {
        return createUserFilePath(user.getPhoneNumber().getNumber());
    }

    private static String createUserFilePath(String phoneNumber) {
        return ResourceLoader.usersDir + "/" + phoneNumber + ".user";
    }

    private static IUser loadUser(String path) {
        return (IUser) FileIO.loadObject(path);
    }

    /**
     * Save the client board and user.
     */
    public static void saveToDisk() throws IOException {
        saveUserToDisk();
        BoardController.saveBoardToDisk();
    }

    public static void saveUserToDisk() throws IOException {
        FileIO.saveObject(Client.getInstance().getUser(), createUserFilePath(Client.getInstance().getUser()));
    }

    /**
     * Load the client object if there is one
     * @return the client object that is stored locally
     */
     private static IClient loadFromDisk() {
        IBoard board = BoardController.loadBoard();
         TagParser tagParser = null;
         try {
             tagParser = new TagParser(ResourceLoader.tagsFile, ResourceLoader.tagsDelimiter);
         } catch (IOException e) {
             // TODO: handle this

         }
         Client.init(null, board, tagParser);
        return Client.getInstance();
    }

    /**
     * Show alert message in GUI
     * @param message an message that will be displayed in the alert
     * @param alertType a type for the alert
     */
    public static void showAlert (String message, Alert.AlertType alertType){
        //Alert myAlert = new Alert(alertType, message, buttonType);
        AlertBannerModule myAlert = AlertBannerModule.getInstance();
        myAlert.setAlertMessage(message, alertType);
    }
}
