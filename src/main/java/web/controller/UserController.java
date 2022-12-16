package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@RequestMapping("/users")
@Controller

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserAll(Model model) {
        model.addAttribute("users", userService.getUserAll());
        return "all-users";
    }

    @GetMapping("/{id}")
    public String showId(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.showId(id));
        return "show";
    }

    @GetMapping("/user-creat")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping
    public String getAddUsers(@ModelAttribute("user") User user) {
        userService.UserSave(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.showId(id));
        return "/edit";

    }

    @PostMapping("/{id}")
    public String update(@PathVariable long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}



