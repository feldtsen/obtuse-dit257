package model.board;

import application.model.board.Board;
import application.model.board.Filter;
import application.model.board.IBoard;
import application.model.posts.IPost;
import application.model.posts.Post;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

public class BoardTest {
    private IPost p1, p2, p3;
    private IBoard board;

    @Before
    public void init() {
        p1 = new Post("p1", "d1", null, "Donation", Set.of("tag1", "tag2", "tag3"));
        p2 = new Post("p2", "d2", null, "Request",  Set.of("tag2", "tag3"));
        p3 = new Post("p3", "d3", null, "Donation", Set.of("tag1", "tag4"));
        board = new Board();
        board.addPost(p1);
        board.addPost(p2);
        board.addPost(p3);
    }

    private boolean equals(List<IPost> l1, List<IPost> l2) {
        return l1.containsAll(l2) && l2.containsAll(l1);
    }

    @Test
    public void testNoFilter() {
        board.setFilter(null);

        List<IPost> expectedPosts = List.of(p1, p2, p3);
        assertTrue(equals(expectedPosts, board.getAllPosts()));
        assertTrue(equals(expectedPosts, board.getVisiblePosts()));
    }

    @Test
    public void testFilterNoMatch() {
        Filter filter = new Filter("Donation", Set.of("tag5"));
        board.setFilter(filter);

        List<IPost> expectedPosts = List.of();
        assertTrue(equals(expectedPosts, board.getVisiblePosts()));
        assertFalse(equals(expectedPosts, board.getAllPosts()));
    }

    @Test
    public void testFilterOneMatch() {
        Filter filter = new Filter("Donation", Set.of("tag4"));
        board.setFilter(filter);

        List<IPost> expectedPosts = List.of(p3);
        assertTrue(equals(expectedPosts, board.getVisiblePosts()));
        assertFalse(equals(expectedPosts, board.getAllPosts()));
    }

    @Test
    public void testFilterMultipleMatch() {
        Filter filter = new Filter("Donation", Set.of("tag1", "tag4"));
        board.setFilter(filter);

        List<IPost> expectedPosts = List.of(p1, p3);
        assertTrue(equals(expectedPosts, board.getVisiblePosts()));
        assertFalse(equals(expectedPosts, board.getAllPosts()));
    }

    @Test
    public void testFilterAllMatch() {
        Filter filter = new Filter(Filter.ALL, Set.of("tag1", "tag2", "tag4"));
        board.setFilter(filter);

        List<IPost> expectedPosts = List.of(p1, p2, p3);
        assertTrue(equals(expectedPosts, board.getVisiblePosts()));
        assertTrue(equals(expectedPosts, board.getAllPosts()));
    }
}
