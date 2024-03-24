package ro.project.fiipractic.Bitter.service;

import ro.project.fiipractic.Bitter.model.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    User searchUserByUserName(String userName);

    List<User> searchUserByFirstName(String firstName);

    List<User> searchUserByLastName(String lastName);

    void followUser(User user);

    void login(String userName, String password);

    User LoggedInUser();
}
