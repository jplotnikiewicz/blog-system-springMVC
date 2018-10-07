package blog.services;

import blog.forms.CommentForm;
import blog.models.Comment;
import blog.models.Post;

import java.util.List;
import java.util.Map;

public interface CommentService {

    List<Comment> findAllForThePost(Post post);
    Comment findById(Long id);
    Comment edit (Comment comment);
    Comment create (CommentForm comment ,Long id);
    public void deleteById(Long id);

}
