package application.model.board;

import application.model.posts.IPost;

import java.util.*;

// The board class holds all posts that might be visible to the user
// A filter can be applied to limit the posts visible.
public class Board implements IBoard {
    // All posts in the board
    private final List<IPost> posts;

    // Map for fetching a specific post based on its UUID
    private final Map<String, IPost> postMap;

    // Filter used for limiting the number of visible posts. Initially this is set to a filter
    // which matches against all posts.
    private transient IFilter filter = new Filter(Filter.ALL, Set.of());

    public Board() {
        this.posts = new ArrayList<>();
        this.postMap = new HashMap<>();
    }

    // Returns a new list containing all posts
    @Override
    public List<IPost> getAllPosts() {
        return new ArrayList<>(posts);
    }

    // Applies the filter and returns the filtered posts
    @Override
    public List<IPost> getVisiblePosts() {
        // If the filter is null, return all posts
        if(filter == null) return getAllPosts();

        List<IPost> filteredPosts = new ArrayList<>();
        // Iterate over all posts and add those which match the filter to the filtered posts list.
        for(IPost post : posts) {
            if(filter.match(post)) {
                filteredPosts.add(post);
            }
        }

        return filteredPosts;
    }

    // Returns a specific post based on its UUID
    @Override
    public IPost getSpecificPost(String id) {
        return postMap.get(id);
    }

    // Adds a post to the board
    @Override
    public void addPost(IPost post) {
        posts.add(post);

        // Also add the post to the post map, for easy lookup
        postMap.put(post.getUniqueID(),post);
    }

    // Replaces a specific post with a new one. This is a useful function when you want to update
    // the contents of a post.
    @Override
    public void replacePost(String id, IPost newPost) {
        // This operation is only possible if the board actually contains a post with the provided id
        if (postMap.containsKey(id)) {
            posts.set(posts.indexOf(postMap.get(id)),newPost);
            postMap.replace(id,newPost);
        }

    }

    // Deletes a post from the board
    @Override
    public boolean deletePost(String id) {
        boolean success = posts.remove(postMap.get(id));
        postMap.remove(id);
        return success;
    }

    @Override
    public void setFilter(IFilter filter) {
        this.filter = filter;
    }

    @Override
    public IFilter getFilter() {
        return filter;
    }
}
