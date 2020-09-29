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

import java.io.*;

public class ClientController {
    public static String createUserFilePath(IUser user) {
        return createUserFilePath(user.getPhoneNumber().toString());
    }

    public static String createUserFilePath(String phoneNumber) {
        return ResourceLoader.usersDir + "/" + phoneNumber + ".user";
    }

    public static void handleSubmitButton(String name, String address, String phoneNumber) {
        IUser user = createUser(name, address, phoneNumber);
        IBoard board = createBoard();

        saveObject(user, createUserFilePath(user));
        saveObject(board, ResourceLoader.boardFile); //TODO: store board on user registration?

        //TODO: login newly created user
    }

    /**
     * Create a user
     * @param name the name of the user
     * @param address the address for the user
     * @param phoneNumber the phone number of the user
     * @return the newly created user object, or a stored one if the user already exists
     */
    public static IUser createUser(String name, String address, String phoneNumber) {
        String path;
        if(new File(path = createUserFilePath(phoneNumber)).exists()) {
            //TODO: error handling? message saying user already exists?
            return loadUser(path);
        }

        PhoneNumber phone;
        try {
            phone = new PhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberException e) {
            return null;
        }
        return new User(name, address, phone);
    }

    public static IBoard createBoard() {
        if(new File(ResourceLoader.boardFile).exists()) {
            return loadBoard(ResourceLoader.boardFile);
        } else {
            return new Board();
        }
    }

    /**
     * Save the client board and user.
     * @param client the client object that needed to be stored
     */
    public static void saveState(IClient client) {
        saveObject(client.getBoard(), ResourceLoader.boardFile);
        saveObject(client.getUser(), createUserFilePath(client.getUser()));
    }

    private static void saveObject(Serializable object, String path) {
        try {
            File file = new File(path);
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            //TODO: error handling
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: error handling
        }
    }

    /**
     * Load the client object if there is one
     * @return the client object that is stored locally
     *          otherwise null
     */
    public static IClient loadState() {
        // TODO: temporary solution (before login, just load first user in directory)
        String[] userPaths = new File(ResourceLoader.usersDir).list();
        if(userPaths == null || userPaths.length == 0) return null;

        IUser user = loadUser(ResourceLoader.usersDir + "/" + userPaths[0]);
        IBoard board = loadBoard(ResourceLoader.boardFile);
        return new Client(user, board);
    }

    public static IUser loadUser(String path) {
        return (IUser)loadObject(path);
    }

    public static IBoard loadBoard(String path) {
        return (IBoard)loadObject(path);
    }

    public static Object loadObject(String path) {
        Object object = null;
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            object = objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            //TODO error handling
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            //TODO: error handling
        }
        return object;
    }

}
