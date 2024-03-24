package ro.project.fiipractic.Bitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.project.fiipractic.Bitter.model.User;
import ro.project.fiipractic.Bitter.service.FollowService;
import ro.project.fiipractic.Bitter.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FollowService followService;

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PutMapping(value = "/{userName}/{password}")
    public void login(@PathVariable("userName") String userName, @PathVariable("password") String password)
    {
        userService.login(userName, password);
    }

    @GetMapping(value = "/username/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User searchUserById(@PathVariable String userName)
    {
        return userService.searchUserByUserName(userName);
    }

    @GetMapping(value = "/firstname/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> searchUserByFirstName(@PathVariable String firstName)
    {
        return userService.searchUserByFirstName(firstName);
    }

    @GetMapping(value = "/lastname/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> searchUserByLastName(@PathVariable String lastName)
    {
        return userService.searchUserByLastName(lastName);
    }

    @PostMapping(value = "/follow")
    public void followUser(@RequestBody User followed)
    {
        User follower = userService.LoggedInUser();
        followService.AddFollow(follower, followed);
    }
}
