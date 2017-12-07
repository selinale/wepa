
package wepa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wepa.repository.UutisRepository;

@Controller
public class UutisController {
    
    @Autowired
    private UutisRepository uutisRepository;
    
//    @GetMapping("*")
//    @ResponseBody
//    public String list(Model model) {
//        model.addAttribute("uutiset", uutisRepository.findAll());
//        return "Hello world!";
//    }
    
    @GetMapping("/uutiset")
    public String list(Model model) {
        PageRequest pageable = PageRequest.of(0, 1000000000, Sort.Direction.DESC, "aika");
        model.addAttribute("uutiset", uutisRepository.findAll(pageable));
        return "/uutiset";
    }
}
