package web.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.hibernate.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @PostMapping
    public String saveUser(User user){
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(User user){
        userService.delete(user.getId());
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, User user){
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

}
