package blog.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 400)
    private String body;

    @Column(nullable = false)
    private Date date = new Date();

    @Column
    private Long parentCommentId;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String author;

    public Comment(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + Id +
                ", body='" + body + '\'' +
                ", date=" + date +
                ", parentCommentId=" + parentCommentId +
                ", postId=" + postId +
                ", author='" + author + '\'' +
                '}';
    }
}
