package web.controller;

import hiber.config.AppConfig;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import hiber.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);
    @GetMapping(value = "/users")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
}

