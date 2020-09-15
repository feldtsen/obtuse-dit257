package application.model.board;

import application.model.posts.IPost;

import java.util.List;

public interface IBoard {
    List<IPost> getVisiblePosts();
    //void setFilter(IFilter);
}
