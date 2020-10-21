package model.board;

import application.model.board.Filter;
import application.model.board.IFilter;
import application.model.posts.IPost;
import application.model.posts.Post;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;

public class FilterTest {
    private final IPost post = new Post("Post", "This is not a post", null, "Donation",
            Set.of("apple", "pear", "orange"), null);

    @Test
    public void testNoMatchType() {
        IFilter filter = new Filter("Request", Set.of("apple", "pear", "orange"));
        assertFalse(filter.match(post));
    }

    @Test
    public void testNoMatchTag() {
        IFilter filter = new Filter("Donation", Set.of("melon"));
        assertFalse(filter.match(post));
    }

    @Test
    public void testNoMatchAll() {
        IFilter filter = new Filter(Filter.ALL, Set.of("melon"));
        assertFalse(filter.match(post));
    }

    @Test
    public void testMatchAll() {
        IFilter filter = new Filter(Filter.ALL, Set.of("apple"));
        assertTrue(filter.match(post));
    }

    @Test
    public void testMatchAllEmptyTags() {
        IFilter filter = new Filter(Filter.ALL, Set.of());
        assertTrue(filter.match(post));
    }

    @Test
    public void testMatchTypeEmptyTags() {
        IFilter filter = new Filter("Donation", Set.of());
        assertTrue(filter.match(post));
    }

    @Test
    public void testMatch() {
        IFilter filter = new Filter("Donation", Set.of("orange", "apple"));
        assertTrue(filter.match(post));
    }

    @Test
    public void testFullMatch() {
        IFilter filter = new Filter("Donation", Set.of("orange", "apple", "pear"));
        assertTrue(filter.match(post));
    }

}
