package application.model.posts;

import application.model.tags.ITag;

import java.util.List;

public interface IItem {
    String getName();
    List<ITag> getTags();
    //Image getImage();
    String getDescription();
}
