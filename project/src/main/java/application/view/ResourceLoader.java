package application.view;


import application.App;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.net.URL;

public class ResourceLoader {
    public final static String stylesheet = App.class.getResource("/styles/style.css").toString();
    public final static InputStream logo = App.class.getResourceAsStream("/application/konrad_logo_sketch_2.png");

}
