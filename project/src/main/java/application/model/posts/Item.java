package application.model.posts;

import application.model.tags.ITag;
import java.util.List;

public class Item implements IItem {
    private final String name;
    private final List<ITag> tags;
    //private final Image image;

    public Item(String name, List<ITag> tags){
        this.name = name;
        this.tags = tags;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ITag> getTags() {
        return tags;
    }
}
