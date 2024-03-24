package ro.project.fiipractic.Bitter.service;

import ro.project.fiipractic.Bitter.model.Post;
import ro.project.fiipractic.Bitter.model.User;

import java.util.List;

public interface PostService {
    void addPost(User user, String message);

    List<Post> getPosts(User user);
}
