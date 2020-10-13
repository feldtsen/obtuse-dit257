package application.model.board;

import application.model.posts.IPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board implements IBoard {
    private final List<IPost> posts;
    private final Map<String,IPost> postMap;
    private IFilter filter;

    private List<IPost> filteredPosts;

    public Board() {
        this.posts = new ArrayList<>();
        this.postMap = new HashMap<>();
        this.filter = null;
        this.filteredPosts = new ArrayList<>();
    }

    @Override
    public List<IPost> getAllPosts() {
        return new ArrayList<>(posts);
    }

    @Override
    public List<IPost> getVisiblePosts() {
        if(filter == null) return posts;

        if(filteredPosts == null) {
            filteredPosts = new ArrayList<>();
            for(IPost post : posts) {
                if(filter.looseMatch(post)) { //TODO: loose match??
                    filteredPosts.add(post);
                }
            }
        }
        return filteredPosts;
    }

    @Override
    public IPost getSpecificPost(String id) {
        return postMap.get(id);
    }

    @Override
    public void addPost(IPost post) {
        posts.add(post);
        postMap.put(post.getUniqueID(),post);
    }

    @Override
    public void replacePost(String id, IPost newPost) {
        if (postMap.containsKey(id)) {
            posts.set(posts.indexOf(postMap.get(id)),newPost);
            postMap.replace(id,newPost);
        }

    }

    @Override
    public boolean deletePost(String id) {
        boolean success = posts.remove(postMap.get(id));
        postMap.remove(id);
        return success;
    }

    @Override
    public void setFilter(IFilter filter) {
        if(this.filter != null && this.filter.equals(filter)) return;
        this.filter = filter;
        filteredPosts = null;
    }
}
