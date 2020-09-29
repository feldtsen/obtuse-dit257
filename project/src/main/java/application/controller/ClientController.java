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
        // TODO: create user file by ID?
        return ResourceLoader.usersDir + "/" + user.getPhoneNumber() + ".user";
    }

    public static void handleSubmitButton(String name, String address, String phoneNumber) {
        //TODO: submit button?
        //IClient newClient = createClient(name, address, phoneNumber);
        IUser user = createUser(name, address, phoneNumber);
        IBoard board = createBoard();
        //saveClient(newClient, ResourceLoader.clientFile);
        saveObject(user, createUserFilePath(user));
        saveObject(board, ResourceLoader.boardFile);
    }

    /**
     * Create a client object with empty board inside
     * @param name the name of the user
     * @param address the address for the user
     * @param phoneNumber the phone number of the user
     * @return the client object
     *          otherwise null
     */
    public static IClient createClient(String name, String address, String phoneNumber) {
        PhoneNumber phone = null;
        try {
            phone = new PhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberException e) {
            e.printStackTrace();
        }

        IUser user = new User(name, address, phone);
        IBoard board = new Board();
        return new Client(user, board);
    }

    public static IUser createUser(String name, String address, String phoneNumber) {
        PhoneNumber phone;
        try {
            phone = new PhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberException e) {
            return null;
        }
        return new User(name, address, phone);
    }

    public static IBoard createBoard() {
        return new Board();
    }

    /**
     * Save the client object to a file according to the path of
     * specified by filename
     * @param client the client object that needed to be stored
     //* @param filename the path to the file used for storing the client object
     */
    /*public static void saveClient(IClient client, String filename) {
        try {
            File clientFile = new File(filename);
            FileOutputStream clientFO = new FileOutputStream(clientFile);
            ObjectOutputStream clientOO = new ObjectOutputStream(clientFO);
            clientOO.writeObject(client);
            clientOO.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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
    /*public static IClient loadClient() {
        IClient client = null;
        try {
            File clientFile = new File(ResourceLoader.clientFile);
            FileInputStream clientFI = new FileInputStream(clientFile);
            ObjectInputStream clientOI = new ObjectInputStream(clientFI);
            client = (IClient) clientOI.readObject();
            clientOI.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return client;
    }*/

    public static IClient loadState() {
        // TODO: temporary solution (before login, just load first user in directory)
        String[] userPaths = new File(ResourceLoader.usersDir).list();
        if(userPaths == null || userPaths.length == 0) return null;

        IUser user = (IUser)loadObject(ResourceLoader.usersDir + "/" + userPaths[0]);
        IBoard board = (IBoard)loadObject(ResourceLoader.boardFile);
        return new Client(user, board);
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
