package application.model.board;

import application.model.posts.IPost;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

// A class used for filtering the posts of a board.
// A filter matches against post type and tags in a post.
// Extends Serializable for the functionality of saving in a .ser file
public class Filter implements IFilter, Serializable {

    // This field is used to when creating a filter that matches against all post types
    public final static String ALL = "ALL";

    // The post type the filter will match against
    private final String postType;

    // The tags the filter will match against
    private final Set<String> tags;

    public Filter(String postType, Set<String> tags) {
        this.postType = postType;
        this.tags = tags;
    }

    @Override
    public String getPostType() {
        return postType;
    }

    @Override
    public Set<String> getTags() {
        return tags;
    }

    // Returns true if the post type matches and the post contains at least one of the filter tags
    @Override
    public boolean match(IPost post) {
        boolean typeMatch = postType.equals(ALL) || // Always match type if postType is "ALL"
                            post.getType().toLowerCase().equals(postType.toLowerCase());
        // Match if there's no tags, or if they have at least one common element
        boolean tagsMatch = tags.isEmpty() || !Collections.disjoint(post.getTags(), tags);
        // Return true if type matches and tags match
        return typeMatch && tagsMatch;
    }
}
