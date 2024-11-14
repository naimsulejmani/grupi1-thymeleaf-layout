package dev.naimsulejmani.grupi1thymeleaflayout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    //List.of();
    private final List<Player> players = new ArrayList<>();

    public PlayerController() {
        players.add(new Player(1, "Lionel", "Messi", "Forward", 37, "Argentina"));
        players.add(new Player(2, "Cristiano", "Ronaldo", "Forward", 39, "Portugal"));
        players.add(new Player(3, "Neymar", "Jr", "Forward", 33, "Brazil"));
        players.add(new Player(4, "Kylian", "Mbappe", "Forward", 25, "France"));
        players.add(new Player(5, "Mohamed", "Salah", "Forward", 32, "Egypt"));
    }

    //http://localhost:8080/players?search=Naim
    @GetMapping("")
    public ModelAndView players(ModelAndView mav
            , @RequestParam(value = "search", required = false) String search
//            , @RequestParam(value="test", required = false) int test
    ) {

        mav.addObject("search", search);
        mav.setViewName("players"); // templates/players.html
        mav.addObject("pageTitle", "Players Page");
//        mav.addObject("players", players);
        System.out.println("search: " + search);

        if (search != null && !search.isBlank()) {
            var searchResult = players.stream()
                    .filter(player ->
                            player.getName().trim().toLowerCase().contains(search.trim().toLowerCase()))
                    .toList();
            mav.addObject("players", searchResult);
        } else {
            mav.addObject("players", players);
        }
        return mav;
    }

//    public String players(Model model) {
//        model.addAttribute("pageTitle", "Players Page");
//        return "players";
//    }

    //get players by id
    // http://localhost:8080/players/1
    @GetMapping("/{id}")
    public String player(Model model, @PathVariable("id") int id) {
        var player = players.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        model.addAttribute("player", player);
        return "player";
    }

    //http://localhost:8080/players/1/edit
    @GetMapping("/{id}/edit")
    public String editPlayer(Model model, @PathVariable("id") int id) {
        var player = players.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        model.addAttribute("player", player);
        return "edit-player";
    }

//    public Player findFirstPlayerById(int id) {
//        Player player = null;
//        for (Player p : players) {
//            if (p.getId() == id) {
//                player = p;
//                break;
//            }
//        }
//        return player;
//    }


}






