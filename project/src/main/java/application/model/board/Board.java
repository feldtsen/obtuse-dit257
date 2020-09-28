package application.model.board;

import application.model.posts.IPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board implements IBoard {
    private final List<IPost> postList;
    private final HashMap<String,IPost> postMap;

    public Board() {
        this.postList = new ArrayList<>();
        this.postMap = new HashMap<>();
    }
    @Override
    public List<IPost> getAllPosts() {
        return postList;
    }

    @Override
    public List<IPost> getVisiblePosts() {
        //return posts;
        //TODO: apply filter
        return null;
    }

    @Override
    public void addPost(IPost post) {
        postList.add(post);
        postMap.put(post.getID(),post);
    }

    @Override
    public void replacePost(String id, IPost newPost) {
        if (postMap.containsKey(id)) {
            postList.set(postList.indexOf(postMap.get(id)),newPost);
            postMap.replace(id,newPost);
        }

    }

    @Override
    public boolean deletePost(String id) {
        boolean success = postList.remove(postMap.get(id));
        postMap.remove(id);
        return success;
    }
}
