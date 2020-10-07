package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;
import application.model.util.TagParser;

public class Client implements IClient{
    private static IClient INSTANCE;

    private IUser user;
    private final IBoard board;
    private final TagParser tagParser;

    private Client(IUser user, IBoard board, TagParser tagParser) {
        this.user = user;
        this.board = board;
        this.tagParser = tagParser;
    }

    public static void init(IUser user, IBoard board, TagParser tagParser) {
        INSTANCE = new Client(user, board, tagParser);
    }

    public static IClient getInstance() {
        return INSTANCE;
    }

    @Override
    public void setUser(IUser user) {
        this.user = user;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public IBoard getBoard() {
        return board;
    }

    //boolean notifyRoom(IPost post);
    //Update getNotifications();

    @Override
    public TagParser getTagParser() {
        return tagParser;
    }
}
