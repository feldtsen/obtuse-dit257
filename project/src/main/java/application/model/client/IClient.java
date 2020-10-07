package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;

import java.io.Serializable;

public interface IClient extends Serializable {
    IUser getUser();
    void setUser(IUser user);
    IBoard getBoard();
    //boolean notifyRoom(IPost post);
    //Update getNotifications();
}
