package application.model.board;

import application.model.posts.IPost;

import java.util.*;

public class Board implements IBoard {
    private final HashMap<String,IPost> postMap;

    public Board() {
        this.postMap = new HashMap<>();
    }

    @Override
    public Collection<IPost> getAllPosts() {
        return new HashSet<>(postMap.values());
    }
    @Override
    public List<IPost> getVisiblePosts() {
        //return posts;
        //TODO: apply filter
        return null;
    }

    @Override
    public IPost getSpecificPost(String id) {
        return postMap.get(id);
    }

    @Override
    public void addPost(IPost post) {
        postMap.put(post.getUUID(),post);
    }

    @Override
    public void replacePost(String id, IPost newPost) {
        if (postMap.containsKey(id)) {
            postMap.replace(id,newPost);
        }

    }

    @Override
    public boolean deletePost(String id) {
        return postMap.remove(id) != null;
    }
}
