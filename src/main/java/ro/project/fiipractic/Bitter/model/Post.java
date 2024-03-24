package ro.project.fiipractic.Bitter.model;

import org.springframework.lang.NonNull;

import java.awt.*;
import java.util.List;
import java.util.Vector;

public class Post {

    private String id;

    private User user;

    @NonNull
    private String message;
    //private Image image;

    private Long timeStamp;

    private List<User> likes;
    private Vector<Comment> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NonNull
    public String getMessage() {
        return message;
    }

    public void setMessage(@NonNull String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public Vector<Comment> getComments() {
        return comments;
    }

    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }
}
