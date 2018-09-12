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



    public Comment() {
    }

    public Comment(Long id, String body, Date date, Long postId) {
        Id = id;
        this.body = body;
        this.date = date;
        this.postId = postId;
        this.parentCommentId = new Long (0);
    }
    public Comment(Long id, String body, Date date, Long postId, Long parentCommentId) {
        Id = id;
        this.body = body;
        this.date = date;
        this.postId = postId;
        this.parentCommentId = parentCommentId;
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + Id +
                ", body='" + body + '\'' +
                ", date=" + date +
                ", postId=" + postId +
                ", parentCommentId=" + parentCommentId +
                '}';
    }



}
