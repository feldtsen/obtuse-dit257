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
            Set.of("apple", "pear", "orange"));

    @Test
    public void strictNoMatchType() {
        IFilter filter = new Filter("Request", Set.of("apple", "pear", "orange"));
        assertFalse(filter.strictMatch(post));
    }

    @Test
    public void strictNoMatchTags() {
        IFilter filter = new Filter("Donation", Set.of("pear", "orange"));
        assertFalse(filter.strictMatch(post));
    }

    @Test
    public void strictNoMatchAll() {
        IFilter filter = new Filter(Filter.ALL, Set.of("pear", "orange"));
        assertFalse(filter.strictMatch(post));
    }

    @Test
    public void strictMatchAll() {
        IFilter filter = new Filter(Filter.ALL, Set.of("apple", "pear", "orange"));
        assertTrue(filter.strictMatch(post));
    }

    @Test
    public void strictMatchTypeTags() {
        IFilter filter = new Filter("Donation", Set.of("apple", "pear", "orange"));
        assertTrue(filter.strictMatch(post));
    }

    @Test
    public void looseNoMatchType() {
        IFilter filter = new Filter("Request", Set.of("apple", "pear", "orange"));
        assertFalse(filter.looseMatch(post));
    }

    @Test
    public void looseNoMatchTag() {
        IFilter filter = new Filter("Donation", Set.of("melon"));
        assertFalse(filter.looseMatch(post));
    }

    @Test
    public void looseNoMatchAll() {
        IFilter filter = new Filter(Filter.ALL, Set.of("melon"));
        assertFalse(filter.looseMatch(post));
    }

    @Test
    public void looseMatchAll() {
        IFilter filter = new Filter(Filter.ALL, Set.of("apple"));
        assertTrue(filter.looseMatch(post));
    }

    @Test
    public void looseMatchAllEmptyTags() {
        IFilter filter = new Filter(Filter.ALL, Set.of());
        assertTrue(filter.looseMatch(post));
    }

    @Test
    public void looseMatchTypeEmptyTags() {
        IFilter filter = new Filter("Donation", Set.of());
        assertTrue(filter.looseMatch(post));
    }

    @Test
    public void looseMatch() {
        IFilter filter = new Filter("Donation", Set.of("orange", "apple"));
        assertTrue(filter.looseMatch(post));
    }

    @Test
    public void looseFullMatch() {
        IFilter filter = new Filter("Donation", Set.of("orange", "apple", "pear"));
        assertTrue(filter.looseMatch(post));
    }

}
