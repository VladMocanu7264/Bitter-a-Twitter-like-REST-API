package ro.project.fiipractic.Bitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.project.fiipractic.Bitter.model.Follow;
import ro.project.fiipractic.Bitter.model.User;
import ro.project.fiipractic.Bitter.repository.FollowDAO;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowDAO followRepository;

    @Autowired
    public FollowServiceImpl(FollowDAO followDAO)
    {
        this.followRepository = followDAO;
    }

    @Override
    public void AddFollow(User follower, User followed) {
        followRepository.addFollow(follower, followed);
    }

    @Override
    public List<Follow> getFollowedUsers(User loggedInUser)
    {
        return followRepository.getFollowedUsers(loggedInUser);
    }
}
