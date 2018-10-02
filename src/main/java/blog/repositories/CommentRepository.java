package blog.repositories;

import blog.models.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>  {

    @Query("SELECT c From Comment c WHERE c.postId = :id ORDER BY c.date")
    List<Comment> findCommentsByThePostId(@Param("id")Long id);
}
