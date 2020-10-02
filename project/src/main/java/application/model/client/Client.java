package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;

public class Client implements IClient{
    private IUser user;
    private final IBoard board;

    public Client(IUser user, IBoard board) {
        this.user = user;
        this.board = board;
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
}
