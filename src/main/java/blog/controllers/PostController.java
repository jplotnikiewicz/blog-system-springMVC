package blog.controllers;

import blog.forms.PostForm;
import blog.models.Post;
import blog.models.User;
import blog.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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


}
