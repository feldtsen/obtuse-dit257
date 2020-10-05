package application.controller;

import application.model.board.Board;
import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import application.ResourceLoader;
import application.view.status.AlertBannerModule;
import application.view.status.LoginBannerModule;
import javafx.scene.control.Alert;

import java.io.*;

public class ClientController {
    public static void init() {
        loadFromDisk();
    }

    public static void handleLoginButton(String phone, String password) {
        String path = createUserFilePath(phone);
        File file = new File(path);
        if(file.exists()) {
            //TODO: add password stuff
            IClient client = loadFromDisk();
            client.setUser(loadUser(path));
            try {
                saveToDisk();
                LoginBannerModule.getInstance().setLoggedInAs(client.getUser().getName());
                showAlert("Login successful as " + client.getUser().getName(), Alert.AlertType.CONFIRMATION);
            } catch (IOException e) {
                showAlert("Error saving data.", Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Please register or type the correct username", Alert.AlertType.ERROR);
        }
    }

    private static String createUserFilePath(IUser user) {
        return createUserFilePath(user.getPhoneNumber().getNumber());
    }

    private static String createUserFilePath(String phoneNumber) {
        return ResourceLoader.usersDir + "/" + phoneNumber + ".user";
    }

    private static IUser loadUser(String path) {
        return (IUser) loadObject(path);
    }

    private static IBoard loadBoard(String path) {
        return (IBoard) loadObject(path);
    }

    public static void handleRegisterButton(String name, String address, String phoneNumber) {
        if (name.equals("")) {
            showAlert( "Name field must be filled", Alert.AlertType.ERROR);
            return;
        }

        if (address.equals("")) {
            showAlert("Address field must be filled", Alert.AlertType.ERROR);
            return;
        }

        // If the user already exist, do not register anew
        if(new File(createUserFilePath(phoneNumber)).exists()) {
            showAlert("A user with the phone number" + phoneNumber + " already exists.", Alert.AlertType.ERROR);
            return;
        }

        IUser user;
        try {
            user = createUser(name, address, phoneNumber);
            saveObject(user, createUserFilePath(user));
            showAlert("You have been registered successfully, please log in", Alert.AlertType.CONFIRMATION);
        } catch (InvalidPhoneNumberException e) {
            showAlert("Your phone number format is invalid", Alert.AlertType.ERROR);
            return;
        } catch (IOException e) {
            showAlert("The user couldn't be saved! Check file path and try again!", Alert.AlertType.ERROR);
        }
        IBoard board = loadBoard();

        try {
            saveObject(board, ResourceLoader.boardFile); //TODO: store board on user registration?
        } catch (IOException e) {
            System.out.println("Saving of board failed");
            System.out.println(e.getMessage());
        }

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
    public static IUser createUser(String name, String address, String phoneNumber) throws InvalidPhoneNumberException {
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
        return new User(name, address, phone);
    }

    public static IBoard loadBoard() {
        // If a stored board already exists
        if (new File(ResourceLoader.boardFile).exists()) {
            // Return the stored board
            return loadBoard(ResourceLoader.boardFile);
        } else {
            // Otherwise, return a new, empty board
            return new Board();
        }
    }

    /**
     * Save the client board and user.
     */
    public static void saveToDisk() throws IOException {
        saveObject(Client.getInstance().getBoard(), ResourceLoader.boardFile);
        saveObject(Client.getInstance().getUser(), createUserFilePath(Client.getInstance().getUser()));

    }

    // Saves a particular object to disk.
    private static void saveObject(Serializable object, String path) throws IOException {
        File file = new File(path);
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        outputStream.close();
    }

    /**
     * Load the client object if there is one
     * @return the client object that is stored locally
     *          otherwise null
     */
     private static IClient loadFromDisk() {
        IBoard board = loadBoard(ResourceLoader.boardFile);
        Client.init(null, board);
        return Client.getInstance();
    }

    /**
     * Load an object
     * @param path the path of the object
     * @return the object otherwise
     *          null
     * Writes a message to console in case of file not found or loading failed.
     */
    private static Object loadObject (String path){
        Object object = null;
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            object = objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loading of object failed");
        }
        return object;
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
