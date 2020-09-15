package application.model;

import java.util.List;

public interface IItem {
    String getName();
    List<ITag> getTags();
    //Image getImage();
    String getDescription();
}
