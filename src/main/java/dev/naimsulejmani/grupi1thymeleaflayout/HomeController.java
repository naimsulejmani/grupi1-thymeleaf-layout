package dev.naimsulejmani.grupi1thymeleaflayout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    private final LocalDateTime STARTED_TIME = LocalDateTime.now();

    @GetMapping("/")
    public String index(Model model) {
        var rnd = Math.random();
        model.addAttribute("random", rnd);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Page");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("pageTitle", "Contact Page");
        return "contact";
    }

    @GetMapping("/random")
    public String random(Model model) {
        model.addAttribute("pageTitle", "Home Page");
        int rnd = (int) (Math.random() * 3);
        return switch (rnd) {
            case 1 -> "about";
            case 2 -> "contact";
            default -> "index";
        };
    }

    //time page
    @GetMapping("/time")
    public String time(Model model) {
        model.addAttribute("pageTitle", "Time Page");
        model.addAttribute("startedTime", STARTED_TIME);
        model.addAttribute("methodCallTime", LocalDateTime.now());
        return "time";
    }
}











