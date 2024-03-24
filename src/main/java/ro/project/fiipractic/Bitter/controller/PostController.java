package ro.project.fiipractic.Bitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.project.fiipractic.Bitter.model.Follow;
import ro.project.fiipractic.Bitter.model.Post;
import ro.project.fiipractic.Bitter.model.User;
import ro.project.fiipractic.Bitter.service.FollowService;
import ro.project.fiipractic.Bitter.service.PostService;
import ro.project.fiipractic.Bitter.service.UserService;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private FollowService followService;

    @PostMapping(value = "/{message}")
    public void addPost(@PathVariable String message)
    {
        postService.addPost(userService.LoggedInUser(), message);
    }

    @GetMapping(value = "/myposts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyPosts()
    {
        return postService.getPosts(userService.LoggedInUser());
    }

    @GetMapping(value = "/myfeed", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getFeed()
    {
        List<Follow> follows = followService.getFollowedUsers(userService.LoggedInUser());

        List<User> followedUser = new LinkedList<>();
        for(Follow follow : follows)
            followedUser.add(follow.getFollowedUser());

        List<Post> posts = new LinkedList<>();
        for(User user : followedUser)
            posts.addAll(postService.getPosts(user));

        return posts;
    }
}
