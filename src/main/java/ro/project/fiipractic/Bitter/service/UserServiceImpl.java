package ro.project.fiipractic.Bitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.project.fiipractic.Bitter.model.User;
import ro.project.fiipractic.Bitter.repository.UserDAO;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userRepository;

    @Autowired
    public UserServiceImpl(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        userRepository.createUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getMail(), user.getPassword());
    }

    @Override
    public User searchUserByUserName(String userName)
    {
        return userRepository.getUserByUserName(userName);
    }

    @Override
    public List<User> searchUserByFirstName(String firstName)
    {
        return userRepository.getUserByFirstName(firstName);
    }

    @Override
    public List<User> searchUserByLastName(String lastName)
    {
        return userRepository.getUserByLastName(lastName);
    }

    @Override
    public void followUser(User user)
    {
        userRepository.AddNewFollowToCurrentLoggedInUser(user);
    }

    @Override
    public void login(String userName, String password)
    {
        userRepository.login(userName, password);
    }

    @Override
    public User LoggedInUser() {
        return userRepository.getLoggedInUser();
    }
}
