package blog.repositories;

import blog.models.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c From Comment c LEFT JOIN c.postId ORDER BY c.date DESC")
    List<Comment> findCommentsByPostId(Pageable pageable);
}
