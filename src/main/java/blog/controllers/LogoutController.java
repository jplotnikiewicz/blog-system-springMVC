package blog.controllers;

import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @Autowired
    UserService userService;

    @RequestMapping("/users/logout")
    public String logout(){

        userService.logout();

        return "redirect:/";
    }



}
