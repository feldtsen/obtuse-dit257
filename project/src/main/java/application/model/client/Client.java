package application.model.client;

import application.model.board.Board;
import application.model.board.IBoard;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;

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
        IUser u1 = null;
        try {
            u1 = new User("Oom", "O'Conner street 420", new PhoneNumber("012323422"));
        } catch (InvalidPhoneNumberException ignored) {
        }
        IBoard b1 = new Board();

        IClient c1 = new Client(u1, b1);

        return c1;
    }

    //boolean notifyRoom(IPost post);
    //Update getNotifications();
}
