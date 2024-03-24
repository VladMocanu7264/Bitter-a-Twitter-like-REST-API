package ro.project.fiipractic.Bitter.model;

public class Comment {

    private Boolean isPublic;
    private int idInPost;
    private int parentIdInPost;

    private String message;

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public int getParentIdInPost() {
        return parentIdInPost;
    }

    public void setParentIdInPost(int parentIdInPost) {
        this.parentIdInPost = parentIdInPost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdInPost() {
        return idInPost;
    }

    public void setIdInPost(int setIdInPost)
    {
        this.idInPost = setIdInPost;
    }
}
