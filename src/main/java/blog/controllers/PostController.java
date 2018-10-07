package blog.controllers;

import blog.forms.CommentForm;
import blog.forms.PostForm;
import blog.models.Comment;
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

    @Autowired
    CommentService commentService;

    @RequestMapping("/posts/create")
    public String writePost(PostForm postForm){
        return "posts/create";
    }


    @RequestMapping(value = "posts/create", method = RequestMethod.POST)
    public String  createPost(@Valid PostForm postForm, BindingResult bindingResult){

        Post createdPost = postService.create(postForm);

        return "redirect:/posts/view/"+ createdPost.getId();
    }

    @RequestMapping(value = "posts/edit/{id}")
    public String editPost( @PathVariable("id") Long id, Model model, PostForm postForm){

        Post post = postService.findById(id);
        model.addAttribute("post", post);
        postService.setPostInSession(post);

        return "/posts/edit";
    }

    @RequestMapping(value = "posts/edit/{id}", method = RequestMethod.POST)
    public String saveEditedPost( @PathVariable("id") Long id, Model model, @Valid PostForm postForm) {

        Post post = postService.edit(postForm);

        return "redirect:/posts/view/" + post.getId();
    }

    @RequestMapping(value = "posts/delete/{id}")
    public String deletePost(@PathVariable("id") Long id, Model model){
        postService.deleteById(id);
        return  "redirect:/";
    }


    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model, CommentForm commentForm){

        Post post = postService.findById(id);

        if(post == null){
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);

        List<Comment> comments = commentService.findAllForThePost(post);
        System.out.print(comments);
        model.addAttribute("comments", comments);

        return "posts/view";
    }

    @RequestMapping(value = "/posts/view/{id}", method = RequestMethod.POST)
    public String view2(@PathVariable("id") Long id, Model model, @Valid CommentForm commentForm){

        commentService.create(commentForm, id);

        return "redirect:/posts/view/"+id;
    }

    @RequestMapping("/posts")
    public String viewAllPosts(Model model){

        List<Post> allPosts = postService.findAll();
        model.addAttribute("posts", allPosts);

        return "posts/viewAll";
    }


}
