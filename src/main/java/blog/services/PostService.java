package blog.services;

import blog.forms.PostForm;
import blog.models.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(PostForm postForm);
    Post edit(PostForm postForm);
    void deleteById(Long id);
    void setPostInSession(Post post);
    Post getPostFromSession();


}
