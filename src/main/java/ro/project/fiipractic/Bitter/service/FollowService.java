package ro.project.fiipractic.Bitter.service;

import ro.project.fiipractic.Bitter.model.Follow;
import ro.project.fiipractic.Bitter.model.User;

import java.util.List;

public interface FollowService {

    void AddFollow(User follower, User followed);

    List<Follow> getFollowedUsers(User loggedInUser);
}
