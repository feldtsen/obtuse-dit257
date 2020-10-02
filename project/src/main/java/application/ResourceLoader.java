package application;


import application.App;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;

import java.io.InputStream;

public class ResourceLoader {
    public final static String stylesheet = App.class.getResource("/styles/style.css").toString();
    public final static InputStream logo = App.class.getResourceAsStream("/application/konrad_logo_sketch_2.png");
    //public final static String clientFile = "clientFile.txt";
    public final static String usersDir = "users";
    public final static String boardFile = "board.ser";
    public final static Insets margin = new Insets(0,  0,   10, 0);

}