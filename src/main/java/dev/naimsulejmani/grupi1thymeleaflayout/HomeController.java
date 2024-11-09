package dev.naimsulejmani.grupi1thymeleaflayout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    private final List<Athlete> athletes = new ArrayList<>();
    private final LocalDateTime STARTED_TIME = LocalDateTime.now();

    public HomeController() {
        athletes.add(new Athlete("Usain", "Bolt", "Sprint", 34, "Jamaica"));
        athletes.add(new Athlete("Michael", "Phelps", "Swimming", 35, "USA"));
        athletes.add(new Athlete("Serena", "Williams", "Tennis", 39, "USA"));
        athletes.add(new Athlete("Simone", "Biles", "Gymnastics", 23, "USA"));
        athletes.add(new Athlete("Medina", "Kutleshi", "Sprint", 20, "Kosova"));
    }

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

    @GetMapping("/example")
    public String example(Model model) {
        model.addAttribute("pageTitle", "Example Page");
        Random rnd = new Random();
        String[] array = {"about", "contact", "index", "test", "time", "example"};
        int index = rnd.nextInt(array.length);
        model.addAttribute("randomPage", array[index]);

        model.addAttribute("athletes", athletes);

        return "example";
    }

}











