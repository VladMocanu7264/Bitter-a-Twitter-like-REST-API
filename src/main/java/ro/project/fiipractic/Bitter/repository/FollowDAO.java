package ro.project.fiipractic.Bitter.repository;

import org.springframework.stereotype.Repository;
import ro.project.fiipractic.Bitter.model.Follow;
import ro.project.fiipractic.Bitter.model.User;

import java.util.LinkedList;
import java.util.List;

@Repository
public class FollowDAO {

    private List<Follow> follows = new LinkedList<>();

    public void addFollow(User follower, User followed) {
        for(Follow follow : follows)
            if(follow.getUser().getUserName().equals(follower.getUserName()))
                if(follow.getFollowedUser().getUserName().equals(followed.getUserName()))
                    return;

        Follow newFollow = new Follow();
        newFollow.setUser(follower);
        newFollow.setFollowedUser(followed);
        newFollow.setTimestamp(System.currentTimeMillis());

        follows.add(newFollow);
    }

    public List<Follow> getFollowedUsers(User loggedInUser) {
        List<Follow> usersFollows = new LinkedList<>();
        for(Follow follow : follows)
            if(follow.getUser().getUserName().equals(loggedInUser.getUserName()))
                usersFollows.add(follow);
        return usersFollows;
    }
}
