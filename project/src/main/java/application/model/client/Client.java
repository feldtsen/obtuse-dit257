package application.model.client;

import application.model.board.Board;
import application.model.board.IBoard;
import application.model.users.IUser;
import application.model.users.User;

public class Client implements IClient{
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

    public static IClient getTest(){
        IUser u1 = new User("Oom", "012323422");
        IBoard b1 = new Board();

        IClient c1 = new Client(u1, b1);

        return c1;
    }

    //boolean notifyRoom(IPost post);
    //Update getNotifications();
}
