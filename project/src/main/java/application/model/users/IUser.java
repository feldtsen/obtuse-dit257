package application.model.users;

import application.model.posts.IPost;
import java.util.List;

public interface IUser {
    String getName();

    String phoneNumber();

    List<IPost> getPosts();
}
