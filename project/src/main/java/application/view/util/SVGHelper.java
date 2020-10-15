package application.view.util;

import javafx.scene.Group;
import javafx.scene.shape.SVGPath;

public class SVGHelper {
    public static Group createIcon (String content, double size) {
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(content);
        svgPath.setScaleX(size);
        svgPath.setScaleY(size);

        return new Group(svgPath);
    }
}
