package application.model.board;

import application.model.posts.IPost;

import java.util.Set;

// A filter is used for filtering the contents of a board
public interface IFilter {
    // Post type is either request or donation
    String getPostType();

    // The tags used for search
    Set<String> getTags();

    // Returns true if a post matches type and at least one tag
    boolean match(IPost post);
}
