
package wepa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UutisController {
    
    //@Autowired
    //private UutisRepository uutisRepository;
    
    @GetMapping("*")
    @ResponseBody
    public String list() {
       // model.addAttribute("uutiset", uutisRepository.findAll());
        return "Hello world!";
    }
}
