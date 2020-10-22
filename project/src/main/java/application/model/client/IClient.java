package application.model.client;

import application.model.board.IBoard;
import application.model.users.IUser;

import java.io.Serializable;

// The client represent the core of the model.
// It holds a user and the board of that user, and a set of tags which can be
// used to tag posts. The user is not tied to the client. Any user can log in and interact
// with the contents of board.
public interface IClient extends Serializable {
    // The user of the client
    IUser getUser();
    void setUser(IUser user);

    // The board of the client
    IBoard getBoard();

    // A class for handling available tags for posts
    TagParser getTagParser();
}
