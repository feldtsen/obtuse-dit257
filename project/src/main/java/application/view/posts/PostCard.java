package application.view.posts;

import application.controller.BoardController;
import application.controller.ClientController;
import application.controller.PostController;
import application.model.posts.IPost;
import application.model.users.IUser;
import application.view.ResourceLoader;
import application.view.pages.BoardPage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostCard extends VBox {

    public PostCard(IPost post) {
       //Appends the post to the board
       BoardPage.getInstance().getChildren().add(this);

       //The author of the current post
       IUser author = post.getAuthor();

       //Creates the GUI elements
       Label  titleLabel          = new Label(post.getTitle());
       Label  nameAndAddressLabel = new Label(author.getName() + ", " + author.getAddress());
       Label  phoneNumberLabel    = new Label("Contact " + author.getPhoneNumber().getNumber());
       Text   descriptionText     = new Text(post.getDescription());
       Button claimButton         = new Button("Claim");
       Button editButton          = new Button("Edit");
       Button deleteButton        = new Button("Delete");

       //List of buttons to be wrapped in a HBox
       List<Button> buttons = new ArrayList<>();

       //Id used for styling and reference
       this.setId("postCard");
       titleLabel.setId("title");
       descriptionText.setId("description");
       claimButton.setId("claimButton");
       editButton.setId("editButton");
       deleteButton.setId("deleteButton");


       //Adds margin between the posts
       VBox.setMargin(this, ResourceLoader.margin);

       //Connect button clicks with a controller
       claimButton.setOnMouseClicked(e-> BoardController.claimButtonHandler(post.getUUID()));
       editButton.setOnMouseClicked(e-> PostController.editPost(post.getUUID()));
       deleteButton.setOnMouseClicked(e-> PostController.deletePost(post.getUUID()));

       //Only the post author should be able to edit the post, and authors should not be able to claim their own post
       String currentUserPhoneNumber = ClientController.loadState().getUser().getPhoneNumber().getNumber();
       if (currentUserPhoneNumber.equals(author.getPhoneNumber().getNumber())) {
          buttons.add(editButton);
          buttons.add(deleteButton);
       } else {
          buttons.add(claimButton);
       }



       //Adds the GUI components to the post
       this.getChildren().setAll(
               titleLabel,
               descriptionText,
               phoneNumberLabel,
               nameAndAddressLabel,
               new ButtonContainer(buttons)
       );

    }

    public VBox getPostContainer () {
       return this;
    }
}
