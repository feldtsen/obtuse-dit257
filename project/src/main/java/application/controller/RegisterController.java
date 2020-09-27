package application.controller;

import application.App;
import application.model.board.Board;
import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import application.view.pages.PageParent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.*;

public class RegisterController {
    public static void handleSubmitButton(String name, String address, String phoneNumber) {
            IClient newClient = createClient(name, address, phoneNumber);
            saveClient(newClient, "clientFile.txt");
    }

    /**
     * Create a client object with empty board inside
     * @param name the name of the user
     * @param address the address for the user
     * @param phoneNumber the phonenumber of the user
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

    /**
     * Save the client object to a file according to the path of
     * specified by filename
     * @param client the client object that needed to be stored
     * @param filename the path to the file used for storing the client object
     */
    public static void saveClient(IClient client, String filename) {
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
    }

    /**
     * Load the client object if there is one
     * @return the client object that is stored locally
     *          otherwise null
     */
    public static IClient loadClient() {
        IClient client = null;
        try {
            File clientFile = new File("clientFile.txt");
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
    }

}
