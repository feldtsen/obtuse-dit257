package application.controller;

import application.model.board.Board;
import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import application.view.ResourceLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

import java.io.*;

public class ClientController {
    private static String createUserFilePath(IUser user) {
        return createUserFilePath(user.getPhoneNumber().toString());
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

    public static void handleSubmitButton(String name, String address, String phoneNumber) {
        if (name.equals("")) {
            System.out.println("Name field must be filled!");
            showAlert("Empty name field", "Name field must be filled!", Alert.AlertType.ERROR, ButtonType.OK);
            return;
        }

        if (address.equals("")) {
            System.out.println("Address field must be filled!");
            showAlert("Empty address field", "Address field must be filled!", Alert.AlertType.ERROR, ButtonType.OK);
            return;
        }

        IUser user = null;
        try {
            user = createUser(name, address, phoneNumber);
            saveObject(user, createUserFilePath(user));
            System.out.println("Registration succeeded!");
            showAlert("Registration succeeded", "You have been registered successfully!", Alert.AlertType.CONFIRMATION, ButtonType.OK);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Phone number is invalid!");
            showAlert("Invalid Phone number", "Your phone number format is invalid", Alert.AlertType.ERROR, ButtonType.OK);
            return;
        } catch (IOException e) {
            System.out.println("The user couldn't be saved!");
            showAlert("Error saving file!", "The user couldn't be saved! Check file path and try again!", Alert.AlertType.ERROR, ButtonType.OK);
        }
        IBoard board = createBoard();

        try {
            saveObject(board, ResourceLoader.boardFile); //TODO: store board on user registration?
        } catch (IOException e) {
            System.out.println("Saving of board failed!");
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
        PhoneNumber phone = new PhoneNumber(phoneNumber);
        return new User(name, address, phone);
    }

    public static IBoard createBoard() {
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
     *
     * @param client the client object that needed to be stored
     */
    public static void saveState(IClient client) throws IOException {
        saveObject(client.getBoard(), ResourceLoader.boardFile);
        saveObject(client.getUser(), createUserFilePath(client.getUser()));

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
    public static IClient loadState () {
        // TODO: temporary solution (before login, just load first user in directory)
        String[] userPaths = new File(ResourceLoader.usersDir).list();
        if (userPaths == null || userPaths.length == 0) return null;

        IUser user = loadUser(ResourceLoader.usersDir + "/" + userPaths[0]);
        IBoard board = loadBoard(ResourceLoader.boardFile);
        return new Client(user, board);
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
            System.out.println("File not found!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loading of object failed!");
        }
        return object;
    }

    /**
     * Show alert message in GUI
     * @param message an message that will be displayed in the alert
     * @param alertType a type for the alert
     */
    private static void showAlert (String title, String message, Alert.AlertType alertType, ButtonType buttonType){
        Alert myAlert = new Alert(alertType, message, buttonType);
        myAlert.setTitle(title);
        myAlert.show();
    }
}
