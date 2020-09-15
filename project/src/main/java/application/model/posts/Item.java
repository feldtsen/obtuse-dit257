package application.model.posts;

import application.model.tags.ITag;
import java.util.List;

public class Item implements IItem {
    public final String name;
    public final List<ITag> tags;
    public final String description;

    public Item(String name, List<ITag> tags, String description){
        this.name = name;
        this.tags = tags;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ITag> getTags() {
        return tags;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
