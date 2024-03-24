package ro.project.fiipractic.Bitter.repository;

import org.springframework.stereotype.Repository;
import ro.project.fiipractic.Bitter.model.Post;
import ro.project.fiipractic.Bitter.model.User;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PostDAO {

    private List<Post> posts = new LinkedList<>();

    public void post(String id, User sender, String message) {

        Post post = new Post();

        post.setId(id);
        post.setMessage(message);
        post.setUser(sender);
        post.setTimeStamp(System.currentTimeMillis());

        posts.add(post);
    }

    public List<Post> getPosts(User user) {
        List<Post> usersPosts = new LinkedList<>();

        for(Post post : posts)
            if(post.getUser().getUserName().equals(user.getUserName()))
                usersPosts.add(post);

        return usersPosts;
    }
}
