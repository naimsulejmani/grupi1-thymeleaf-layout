package dev.naimsulejmani.grupi1thymeleaflayout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    private List<String> students = List.of("Naim", "Ardi", "Ardit", "Ardita", "Ardian", "Ardiana", "Ardiansyah");

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", students);
        model.addAttribute("rnd", new Random().nextInt(2));
        return "students";
    }
}
