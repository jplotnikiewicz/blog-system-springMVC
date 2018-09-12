package blog.services;

import blog.models.Comment;
import blog.models.Post;
import blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentServiceImpl implements CommentService {


    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAllForThePost(Post post) {
        return null;
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
    public Comment create(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        this.commentRepository.deleteById(id);
    }
}
