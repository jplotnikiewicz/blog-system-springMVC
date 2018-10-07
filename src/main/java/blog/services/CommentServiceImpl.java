package blog.services;

import blog.forms.CommentForm;
import blog.models.Comment;
import blog.models.Post;
import blog.models.User;
import blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    CommentRepository commentRepository;

    @Autowired
    HttpSession httpSession;

    @Override
    public List<Comment> findAllForThePost(Post post) {

        List<Comment> comments = commentRepository.findCommentsByThePostId(post.getId());
        return comments;
    }

    @Override
    public Comment findById(Long id) {

        List<Long> ids = new ArrayList<>(1);
        ids.add(id);
        List<Comment> comments = commentRepository.findAllById(ids);
        Comment comment = comments.get(0);

        return comment;
    }

    @Override
    public Comment edit(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment create(CommentForm commentForm, Long id) {

        User author =(User) httpSession.getAttribute( UserServiceImpl.LOGGED_USER_SESSION_KEY);

        Comment comment = new Comment();
        comment.setBody(commentForm.getBody());
        comment.setPostId(id);
        comment.setAuthor(author);

        return this.commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        this.commentRepository.deleteById(id);
    }
}
