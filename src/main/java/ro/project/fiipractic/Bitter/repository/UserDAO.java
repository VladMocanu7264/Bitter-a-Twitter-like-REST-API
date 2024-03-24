package ro.project.fiipractic.Bitter.repository;

import org.springframework.stereotype.Repository;
import ro.project.fiipractic.Bitter.exception.IncorrectUsernameOrPasswordException;
import ro.project.fiipractic.Bitter.exception.NotLoggedInException;
import ro.project.fiipractic.Bitter.exception.UserNotFoundException;
import ro.project.fiipractic.Bitter.exception.UsernameAlreadyInUseException;
import ro.project.fiipractic.Bitter.model.Follow;
import ro.project.fiipractic.Bitter.model.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@Repository
public class UserDAO {

    private Vector<User> users;
    private Integer loggedInUserIndex;

    public void setLoggedInUserIndex(Integer index)
    {
        if(index >= 0 && index < users.size())
            loggedInUserIndex = index;
    }

    public UserDAO()
    {
        this.loggedInUserIndex = -1;
        this.users = new Vector<>();
    }

    public void createUser(String userName, String firstName, String lastName, String mail, String password) {
        for(User user : users)
            if(user.getUserName().equals(userName))
                throw new UsernameAlreadyInUseException("This username is already in use");

        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setMail(mail);
        newUser.setPassword(password);

        users.add(newUser);
    }

    public User getUserByUserName(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName))
                return user;
        }
        throw new UserNotFoundException(String.format("User with username %s was not found", userName));
    }

    public List<User> getUserByFirstName(String firstName)
    {
        List<User> foundUsers = new LinkedList<User>();

        for (User user : users) {
            if (user.getFirstName().equals(firstName))
                foundUsers.add(user);
        }

        if(!foundUsers.isEmpty())
            return foundUsers;
        else
            throw new UserNotFoundException(String.format("User with the first name %s was not found", firstName));
    }

    public List<User> getUserByLastName(String lastName)
    {
        List<User> foundUsers = new LinkedList<User>();

        for (User user : users) {
            if (user.getLastName().equals(lastName))
                foundUsers.add(user);
        }

        if(!foundUsers.isEmpty())
            return foundUsers;
        else
            throw new UserNotFoundException(String.format("User with the last name %s was not found", lastName));
    }

    public User getLoggedInUser()
    {
        if(loggedInUserIndex != -1)
            return users.get(loggedInUserIndex);
        else
            throw new NotLoggedInException("You are not logged in");
    }

    public void AddNewFollowToCurrentLoggedInUser(User user) {
    }

    public void login(String userName, String password) {
        int numberOfUsers = users.size();
        for (int i = 0; i<numberOfUsers; ++i) {
            if (users.get(i).getUserName().equals(userName))
            {
                if(users.get(i).getPassword().equals(password)) {
                    setLoggedInUserIndex(i);
                    return;
                }
                else
                    throw new IncorrectUsernameOrPasswordException("The password are incorrect");
            }
        }

        throw new IncorrectUsernameOrPasswordException("The username and/or password are incorrect");
    }
}