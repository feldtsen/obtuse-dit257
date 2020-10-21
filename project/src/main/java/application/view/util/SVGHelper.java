package application.view.util;

import javafx.scene.Group;
import javafx.scene.shape.SVGPath;

/*
*  Helper class to load SVG files used for icons
* */

public class SVGHelper {
    public static Group createIcon (String content, double size) {
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(content);
        svgPath.setScaleX(size);
        svgPath.setScaleY(size);

        // Returns as group so we can set it as a child directly
        return new Group(svgPath);
    }
}
