package com.trilogyed.stwitter.viewModel;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostViewModel {

    private int postID;
    private LocalDate postDate;
    @NotEmpty
    private String posterName;
    @NotEmpty
    private String post;
    List<CommentViewModel> cList = new ArrayList<>();

    public PostViewModel() {
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void addComments(CommentViewModel commentViewModel){
        cList.add(commentViewModel);
    }
    public void removeComments(CommentViewModel commentViewModel){
        cList.remove(commentViewModel);
    }

    public List<CommentViewModel> getComments() {
        return cList;
    }

    public void setComments(List<CommentViewModel> comments) {
        this.cList = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return getPostID() == that.getPostID() &&
                Objects.equals(getPostDate(), that.getPostDate()) &&
                Objects.equals(getPosterName(), that.getPosterName()) &&
                Objects.equals(getPost(), that.getPost()) &&
                Objects.equals(getComments(), that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostID(), getPostDate(), getPosterName(), getPost(), getComments());
    }

    @Override
    public String toString() {
        return "PostViewModel{" +
                "postID=" + postID +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                ", cList=" + cList +
                '}';
    }
}
