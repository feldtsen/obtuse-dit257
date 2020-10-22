package application.view.pages.board.posts;

import application.controller.PostController;
import application.model.client.Client;
import application.model.posts.IPost;
import application.model.users.IUser;
import application.view.pages.util.TagDisplay;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// UI element for showing the contents of the Post model class
// This class displays all relevant information related to a post,
// included user specific information such as phone number and address
public class PostCard extends VBox {

    public PostCard (IPost post) {

        // The author of the current post
        IUser author = post.getAuthor();

        // Creates the different labels, texts and buttons
        Label postTypeLabel           = new Label(post.getType());
        Label titleLabel              = new Label(post.getTitle());
        Label nameAndAddressLabel     = new Label(author.getName() + ", " + author.getAddress());
        Label phoneNumberLabel        = new Label("Contact " + author.getPhoneNumber().getNumber());
        Text descriptionText          = new Text(post.getDescription());
        TextFlow descriptionContainer = new TextFlow(descriptionText);
        Button editButton             = new Button("Edit");
        Button deleteButton           = new Button("Delete");

        // Create and initialize container for tags
        TagDisplay tagDisplay = new TagDisplay(post.getTags());

        //List of buttons to be wrapped in a HBox
        List<Button> buttons = new ArrayList<>();

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

        // Load image if a path is defined in the post
        ImageView imageView = new ImageView();
        if(post.getImagePath() != null) {
            String path = post.getImagePath();

            // Create new image and set it to the view
            Image image = new Image(new File(path).toURI().toString());
            imageView.setImage(image);
            // TODO: not hardcode width, this needs to be reflected in the column constraints
            // Set styling and dimensions
            imageView.setFitWidth(280);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);

            // We need a shape we can clip the image into so that we get rounded corners
            Rectangle clip = new Rectangle(imageView.getFitWidth(), 200);
            clip.setArcWidth(10);
            clip.setArcHeight(10);
            imageView.setClip(clip);

            // We set the shape to be transparent, we only want the rounded corners
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);
            WritableImage writableImage = imageView.snapshot(parameters, null);
            imageView.setClip(null);

            imageView.setImage(writableImage);
        }


        // We do not want padding around the picture
        VBox childrenWithPadding = new VBox();
        VBox.setVgrow(childrenWithPadding, Priority.ALWAYS);
        Region spaceBetween = new Region(); // Used to force content to the bottom of the card
        VBox.setVgrow(spaceBetween, Priority.ALWAYS);
        childrenWithPadding.getChildren().setAll(
                titleLabel,
                postTypeLabel,
                tagDisplay,
                descriptionContainer,
                spaceBetween,
                phoneNumberLabel,
                nameAndAddressLabel,
                new ButtonContainer(buttons)
        );

        // Apply CSS classes for styling
        childrenWithPadding.getStyleClass().add("padding");
        childrenWithPadding.getStyleClass().add("spacing");
        descriptionText.getStyleClass().add("description");
        deleteButton.getStyleClass().add("deleteButton");

        //Id used for styling and reference
        this.getStyleClass().add("cardBackground");

        //Adds the GUI components to the post
        this.getChildren().setAll(
                imageView,
                childrenWithPadding

        );

    }

    // This is the empty card, get the same width no matter the amount of posts present on the board
    // See boardController to see how it is used
    public PostCard ()
    {
        this.setVisible(false);
        // Add a child that is always taking the available space to extend to the card's width
        // This will ensure correct boardPage width
        this.getChildren().setAll(
              new Button()
        );
    }


}

