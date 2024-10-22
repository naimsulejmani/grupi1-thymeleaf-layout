package dev.naimsulejmani.grupi1thymeleaflayout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
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
}
