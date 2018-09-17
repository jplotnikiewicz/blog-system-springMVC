package blog.controllers;

import blog.forms.PostForm;
import blog.models.Post;
import blog.models.User;
import blog.services.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/posts/create")
    public String writePost(PostForm postForm){
        return "posts/create";
    }


    @RequestMapping(value = "posts/create", method = RequestMethod.POST)
    public String  createPost(@Valid PostForm postForm, BindingResult bindingResult){

        User author =(User) httpSession.getAttribute( UserServiceImpl.LOGGED_USER_SESSION_KEY);

        Post newPost = new Post();
        newPost.setBody(postForm.getBody());
        newPost.setTitle(postForm.getTitle());
        newPost.setAuthor(author);

        Post createdPost = postService.create(newPost);

        return "redirect:/posts/view/"+ createdPost.getId();
    }

    @RequestMapping(value = "posts/edit/{id}")
    public String editPost(@PathVariable("id") Long id, Model model, PostForm postForm){

        Post post = postService.findById(id);
        //model.addAttribute()
        postForm = new PostForm();
        postForm.setBody(post.getBody());
        postForm.setTitle(post.getTitle());

        return "/posts/create/"+post.getId();
    }

    @RequestMapping(value = "posts/edit/{id}", method = RequestMethod.POST)
    public String saveEditedPost(@PathVariable("id") Long id, @Valid PostForm postForm){
        Post post = postService.findById(id);

        post.setTitle(postForm.getTitle());

        post.setBody(postForm.getBody());
        return "redirect:/posts/view/" + id;
    }

    @RequestMapping(value = "posts/delete/{id}")
    public String deletePost(@PathVariable("id") Long id, Model model){
        postService.deleteById(id);
        return  "redirect:/";
    }

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);
        if(post == null){
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts")
    public String viewAllPosts(Model model){

        List<Post> allPosts = postService.findAll();
        model.addAttribute("posts", allPosts);

        return "posts/viewAll";
    }


}
