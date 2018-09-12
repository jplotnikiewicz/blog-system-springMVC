package blog.services;

import blog.models.Comment;
import blog.models.Post;

import java.util.List;
import java.util.Map;

public interface CommentService {

    List<Comment> findAllForThePost(Post post);
    Comment findById(Long id);
    Comment edit (Comment comment);
    Comment create (Comment comment);
    public void deleteById(Long id);

}
