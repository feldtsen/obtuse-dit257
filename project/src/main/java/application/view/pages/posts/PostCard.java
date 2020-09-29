package application.view.pages.posts;

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
       Text   postUuidHiddenText  = new Text(post.getUUID());
       Button claimButton         = new Button("Claim");
       Button editButton          = new Button("Edit");

       //Id used for styling and reference
       this.setId("postCard");
       titleLabel.setId("title");
       descriptionText.setId("description");
       postUuidHiddenText.setId("id");
       claimButton.setId("claimButton");
       editButton.setId("editButton");


       //Adds margin between the posts
       VBox.setMargin(this, ResourceLoader.margin);

       //Connect button clicks with a controller
       claimButton.setOnMouseClicked(BoardController::claimButtonHandler);
       editButton.setOnMouseClicked(PostController::editPost);

       //Only the post author should be able to edit the post
       if (!Objects.requireNonNull(ClientController.loadState()).getUser().getName().equals(post.getAuthor().getName()))
           editButton.setVisible(false);

       //The UUID of the post should not be visible to the user - we need it to reference the currently clicked post
       postUuidHiddenText.setVisible(false);

       //Adds the GUI components to the post
       this.getChildren().setAll(
               titleLabel,
               descriptionText,
               phoneNumberLabel,
               nameAndAddressLabel,
               editButton,
               claimButton,
               postUuidHiddenText
       );

    }
}

