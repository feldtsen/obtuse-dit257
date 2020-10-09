package application.model.board;

import application.model.posts.IPost;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Filter implements IFilter {
    public final static String ALL = "ALL";
    private final String postType;
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

    @Override
    public boolean strictMatch(IPost post) {
        boolean typeMatch = postType.equals(ALL) || // Always match type if postType is "ALL"
                              post.getPostType().toLowerCase().equals(postType.toLowerCase());
        boolean tagsMatch = tags.containsAll(post.getTags()); // Check if all tags match
        return typeMatch && tagsMatch;
    }

    @Override
    public boolean looseMatch(IPost post) {
        boolean typeMatch = postType.equals(ALL) || // Always match type if postType is "ALL"
                            post.getPostType().toLowerCase().equals(postType.toLowerCase());
        // Match if there's no tags, or if they have at least one common element
        boolean tagsMatch = tags.isEmpty() || !Collections.disjoint(post.getTags(), tags);
        return typeMatch && tagsMatch;
    }
}
