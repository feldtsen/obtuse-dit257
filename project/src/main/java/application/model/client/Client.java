package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;

// Core model class, holds a user and a board and a set of tags
// Singleton pattern is implemented to ensure only one client can
// be created for a running instance of the application.
public class Client implements IClient {
    // Global instance
    private static IClient instance;

    // User of client
    private IUser user;

    // Board of client
    private final IBoard board;

    // Available tags
    private final TagParser tagParser;

    private Client(IUser user, IBoard board, TagParser tagParser) {
        this.user = user;
        this.board = board;
        this.tagParser = tagParser;
    }

    // Initializes the global client instance. The user may be null, if no user is logged in
    // at initialization.
    public static void init(IUser user, IBoard board, TagParser tagParser) {
        instance = new Client(user, board, tagParser);
    }


    public static IClient getInstance() {
        return instance;
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

    @Override
    public TagParser getTagParser() {
        return tagParser;
    }
}
