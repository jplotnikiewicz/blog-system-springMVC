package blog.controllers;

import blog.forms.RegistryForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping("/register")
    public String registry(Model model, RegistryForm registryForm){
        return "users/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registryPage(@Valid RegistryForm registryForm, BindingResult bindingResult){

        User user = new User();
        user.setFullName(registryForm.getFullName());
        user.setUsername(registryForm.getUsername());
        user.setPasswordHash(registryForm.getPassword());

        userService.create(user);
        notificationService.addInfoMessage("Register succesfull");

        return "redirect:/";
    }




}
