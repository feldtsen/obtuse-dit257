package model.client;

import static org.junit.Assert.*;
import application.model.board.Board;
import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.users.IUser;
import application.model.users.User;
import application.model.util.InvalidPhoneNumberException;
import application.model.util.PhoneNumber;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
    IUser user;
    IBoard board;
    IClient client;

    @Before
    public void init() {
        try {
            user = new User("TestName", "Teststreet", new PhoneNumber("00000000000"));
        } catch (InvalidPhoneNumberException ignored) {
        }
        board = new Board();
        //client = new Client(user,board);
        Client.init(user, board);
        client = Client.getInstance();

    }

    @Test
    public void userAddedToClientIsActuallyTheRightUser(){
        assertEquals(client.getUser(), user);
    }
}
