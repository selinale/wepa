package wepa.controllers;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wepa.domain.Uutinen;
import wepa.repository.UutisRepository;

@Controller
public class UutisController {

    @Autowired
    private UutisRepository uutisRepository;

    @RequestMapping("/")
    public String handleDefault() {
        return "redirect:/uutiset";
    }

    @GetMapping("/uutiset")
    public String list(Model model) {
        PageRequest pageable = PageRequest.of(0, 1000000000, Sort.Direction.DESC, "aika");
        model.addAttribute("uutiset", uutisRepository.findAll(pageable));
        return "uutiset";
    }

    @GetMapping("/uutiset/{id}")
    public String katsoUutinen(Model model, @PathVariable Long id) {
        model.addAttribute("uutinen", uutisRepository.getOne(id));
        return "kakka";
    }
    
    @GetMapping("/uutiset/uusi")
    public String uusiUutinen() {
        return "uutiset_uusi";
    }

    @PostMapping("/uutiset")
    public String lisaaUutinen(@RequestParam String otsikko, @RequestParam String ingressi, @RequestParam String teksti) {
        Uutinen uutinen = new Uutinen();
        uutinen.setOtsikko(otsikko);
        uutinen.setIngressi(ingressi);
        uutinen.setTeksti(teksti);
        uutisRepository.save(uutinen);
        return "redirect:/uutiset";
    }
}
