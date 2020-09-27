package application.view;


import application.App;

public class StylesheetRetriever {
    public final static String stylesheet = App.class.getResource("/styles/style.css").toString();
}
