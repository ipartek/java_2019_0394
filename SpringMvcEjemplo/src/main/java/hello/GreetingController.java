package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@ModelAttribute("persona") Persona persona) {
        //persona.setNombre(persona.getNombre().toUpperCase());
        return "greeting";
    }

}