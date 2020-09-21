package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;

public class Client {
    private final IUser user;
    private final IBoard board;

    public Client(IUser user, IBoard board) {
        this.user = user;
        this.board = board;
    }

    public IUser getUser() {
        return user;
    }

    public IBoard getBoard() {
        return board;
    }

    //boolean notifyRoom(IPost post);
    //Update getNotifications();
}
