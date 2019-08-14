package ru.srb.lcsweatermailverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.srb.lcsweatermailverification.domain.Role;
import ru.srb.lcsweatermailverification.domain.User;
import ru.srb.lcsweatermailverification.repos.RoleRepo;
import ru.srb.lcsweatermailverification.repos.UserRepo;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepo.findAll());

        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam Map<String, String> form, @RequestParam("userId") User user) {

        user.setUsername(username);
        user.getRoles().clear();

        List<Role> roles = roleRepo.findAll();

        for (String key: form.keySet()) {
            for (Role role: roles) {
                if (key.equals(role.getName())) {
                    user.getRoles().add(role);
                }
            }
        }

        userRepo.save(user);

        return "redirect:/user";
    }
}