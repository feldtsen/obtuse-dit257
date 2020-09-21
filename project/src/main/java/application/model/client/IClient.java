package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;

public interface IClient {
    IUser getUser();
    IBoard getBoard();
    //boolean notifyRoom(IPost post);
    //Update getNotifications();
}
