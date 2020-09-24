package application.controller;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import application.App;
import application.model.board.Board;
import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.Donation;
import application.model.posts.IPost;
import application.model.posts.Post;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class WindowController implements Initializable {

    String fileName = "clientFile.txt";

    @FXML
    VBox content;
    @FXML
    Button signupB;
    @FXML
    Button signupSubmitB;
    @FXML
    TextField signupNameTF;
    @FXML
    TextField signupPhoneTF;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleSignupButton(ActionEvent e) {
        if(e.getSource() == signupB) {
            try {
                //clear anything in the content area of main window
                content.getChildren().clear();
                //loads the signup window
                VBox signupWindow = FXMLLoader.load(App.class.getResource("signup.fxml"));
                //add it to content area to display it on screen
                content.getChildren().add(signupWindow);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @FXML
    private void handleSignupSubmitButton(ActionEvent e) {
        if(e.getSource() == signupSubmitB) {
            IClient newClient = createClient(signupNameTF.getText(), signupPhoneTF.getText());
            saveClient(newClient, fileName);
        }
    }

    @FXML
    private void generatePost(ActionEvent e) {
        IClient client = loadClient();
        //The button being pressed
        Button publishSiteButton = (Button) e.getSource();
        // Need to get to the right level in the hierarchy
        VBox publishSiteContainer = (VBox) publishSiteButton.getParent().getParent();

        //Retrieves the content of the title input field
        String titleText = ((TextArea) publishSiteContainer.lookup("#titleInput")).getText();
        //Retrieves the content of the description field
        String descriptionText =((TextArea) publishSiteContainer.lookup("#descriptionInput")).getText();

        //Generates the new post and adds it to the board
        Post newPost = new Donation(titleText, descriptionText, client.getUser(), null);
        client.getBoard().addPost(newPost);
        saveClient(client, fileName);
    }

    @FXML
    private void handlePublishButton() throws IOException {
        //loads the specified page
        VBox root = FXMLLoader.load(App.class.getResource("publishSite.fxml"));
        //adds margin of the site loaded
        VBox.setMargin(root, new Insets(20, 0, 0, 0));
        //removes current page and updates with the requested site
        content.getChildren().setAll(root);
    }

    @FXML
    private void handleBoardButton() {
        IClient client = loadClient();
        PostGenerator postGenerator = new PostGenerator(content);

        List<IPost> posts = client.getBoard().getAllPosts();

        for (IPost post : posts) {
            postGenerator.createDonation(post);
        }
    }


    private IClient createClient(String name, String phonenumber) {
        IClient client = null;
        try {
            PhoneNumber phonenumberObj = new PhoneNumber(phonenumber);
            IUser user = new User(name, phonenumberObj);
            IBoard board = new Board();
            client = new Client(user, board);
        } catch (InvalidPhoneNumberException e1) {
            System.out.println("Invalid phone number!");
        }
        return client;
    }

    private void saveClient(IClient client, String filename) {
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

    private IClient loadClient() {
        IClient client = null;
        try {
            File clientFile = new File("clientFile.txt");
            FileInputStream clientFI = new FileInputStream(clientFile);
            ObjectInputStream clientOI = new ObjectInputStream(clientFI);
            client = (IClient) clientOI.readObject();
            clientOI.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return client;
    }
}
