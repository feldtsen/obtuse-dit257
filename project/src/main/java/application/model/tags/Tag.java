package application.model.tags;

public class Tag implements ITag{

    private final String name;
    private final String description;

    public Tag(String name, String description){
        this.name = name;
        this.description = description;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
