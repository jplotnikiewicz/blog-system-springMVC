package blog.services;

import blog.models.Post;
import blog.models.User;
import blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

    @Override
    public List<Post> findLatest5() {
        List<Post> posts = postRepo.findLatest5Posts(PageRequest.of(0, 5));
        return posts;
    }

    @Override
    public Post findById(Long id) {

        List<Long> ids = new ArrayList<>(1);
        ids.add(id);
        List<Post> posts = this.postRepo.findAllById(ids);
        Post post = posts.get(0);
        return post;
    }

    @Override
    public Post create(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {

        this.postRepo.deleteById(id);
    }
}
