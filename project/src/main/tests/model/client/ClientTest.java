package model.client;

import static org.junit.Assert.*;
import application.model.board.Board;
import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.users.IUser;
import application.model.users.User;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
    IUser user;
    IBoard board;
    IClient client;

    @Before
    public void init() {
        user = new User("TestName", "+00000000000");
        board = new Board();
        client = new Client(user,board);

    }

    @Test
    public void userAddedToClientIsActuallyTheRightUser(){
        assertEquals(client.getUser(), user);
    }
}
