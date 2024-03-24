package ro.project.fiipractic.Bitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.project.fiipractic.Bitter.model.Post;
import ro.project.fiipractic.Bitter.model.User;
import ro.project.fiipractic.Bitter.repository.PostDAO;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostDAO postRepository;
    private final PostIdGenerator postIdGenerator;

    @Autowired
    public PostServiceImpl(PostDAO postDAO, PostIdGenerator postIdGenerator)
    {
        this.postRepository = postDAO;
        this.postIdGenerator = postIdGenerator;
    }

    public void addPost(User user, String message)
    {
        String id = postIdGenerator.generateId(user.getUserName(), message);
        postRepository.post(id, user, message);
    }

    public List<Post> getPosts(User user)
    {
        return postRepository.getPosts(user);
    }
}
