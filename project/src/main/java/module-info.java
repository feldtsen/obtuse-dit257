module org.openjfx {
    requires javafx.graphics;
    requires javafx.controls;

    exports application to javafx.graphics, javafx.controls;
}