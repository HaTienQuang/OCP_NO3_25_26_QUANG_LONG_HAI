package com.sieuthi.controller;
import com.sieuthi.model.User;
import com.sieuthi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    public UserController(UserService service){this.service=service;}

    @GetMapping
    public String list(Model model){
        model.addAttribute("ds", service.findAll());
        return "user/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User u){
        service.save(u);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("user", service.findById(id));
        return "user/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/user";
    }
}
