package application;


import java.io.InputStream;

public class ResourceLoader {
    public final static String stylesheet = App.class.getResource("/styles/style.css").toString();
    public final static InputStream logo = App.class.getResourceAsStream("/application/konrad_logo_sketch_2.png");
    public final static InputStream logoText = App.class.getResourceAsStream("/application/konrad_logo_text.png");
    public final static InputStream logoSymbol = App.class.getResourceAsStream("/application/konrad_symbol.png");
    public final static String usersDir = "users";
    public final static String boardFile = "board.ser";
    public final static String tagsFile = App.class.getResource("tags.csv").getPath();
    public final static String tagsDelimiter = "#";

}
