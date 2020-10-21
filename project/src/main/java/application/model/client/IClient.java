package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;

import java.io.Serializable;

public interface IClient extends Serializable {
    IUser getUser();
    void setUser(IUser user);
    IBoard getBoard();
    TagParser getTagParser();
}
