package application.view.pages.board.posts;

import application.controller.PostController;
import application.model.client.Client;
import application.model.posts.IPost;
import application.model.users.IUser;
import application.view.pages.util.TagDisplay;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

public class PostCard extends VBox {

    public PostCard(IPost post) {
       //The author of the current post
       IUser author = post.getAuthor();

       //Creates the GUI elements
       Label  postTypeLabel          = new Label(post.getType());
       Label  titleLabel             = new Label(post.getTitle());
       Label  nameAndAddressLabel    = new Label(author.getName() + ", " + author.getAddress());
       Label  phoneNumberLabel       = new Label("Contact " + author.getPhoneNumber().getNumber());
       Text descriptionText          = new Text(post.getDescription());
       TextFlow descriptionContainer = new TextFlow(descriptionText);
       Button editButton             = new Button("Edit");
       Button deleteButton           = new Button("Delete");

       // Create and initialize container for tags
       TagDisplay tagDisplay = new TagDisplay(post.getTags());

       //List of buttons to be wrapped in a HBox
       List<Button> buttons = new ArrayList<>();

       //Id used for styling and reference
       this.getStyleClass().add("cardBackground");
       this.getStyleClass().add("spacing");
       this.getStyleClass().add("padding");

       descriptionText.getStyleClass().add("description");

       deleteButton.getStyleClass().add("deleteButton");

       //Connect button clicks with a controller
       editButton.setOnMouseClicked(e-> PostController.editPost(post.getUniqueID()));
       deleteButton.setOnMouseClicked(e-> PostController.deletePost(post.getUniqueID()));

       // No options if no user is logged in
       if(Client.getInstance().getUser() != null) {
          //Only the post author should be able to edit the post, and authors should not be able to claim their own post
          String currentUserPhoneNumber = Client.getInstance().getUser().getPhoneNumber().getNumber();
          if (currentUserPhoneNumber.equals(author.getPhoneNumber().getNumber())) {
             buttons.add(editButton);
             buttons.add(deleteButton);
          }
       }

       // Load image
       /*ImageView imageView = null;
       if(post.getImagePath() != null) {
          String path = "file:" + post.getImagePath();
          System.out.println(path);
          imageView = new ImageView(path);
          imageView.setFitWidth(100);
          imageView.setPreserveRatio(true);
          imageView.setSmooth(true);
          imageView.setCache(true);
       }*/

       //Adds the GUI components to the post
       this.getChildren().setAll(
               postTypeLabel,
               tagDisplay,
               titleLabel,
               descriptionContainer,
               phoneNumberLabel,
               nameAndAddressLabel,
               new ButtonContainer(buttons)
               //imageView
       );

       /*if(imageView != null) {
          this.getChildren().add(imageView);
       }*/
    }
}

