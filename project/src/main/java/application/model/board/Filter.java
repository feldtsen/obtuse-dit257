package application.model.board;

import application.model.posts.IPost;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class Filter implements IFilter, Serializable {
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
                              post.getType().toLowerCase().equals(postType.toLowerCase());
        boolean tagsMatch = tags.containsAll(post.getTags()); // Check if all tags match
        return typeMatch && tagsMatch;
    }

    @Override
    public boolean looseMatch(IPost post) {
        boolean typeMatch = postType.equals(ALL) || // Always match type if postType is "ALL"
                            post.getType().toLowerCase().equals(postType.toLowerCase());
        // Match if there's no tags, or if they have at least one common element
        boolean tagsMatch = tags.isEmpty() || !Collections.disjoint(post.getTags(), tags);
        return typeMatch && tagsMatch;
    }

    public static IFilter combineFilter(IFilter f1, IFilter f2) {
        Set<String> tags = f1.getTags();
        tags.addAll(f2.getTags());
        return new Filter(f1.getPostType(), tags);
    }

    @Override
    public void addTag(String tag) {
        tags.add(tag);
    }
}
