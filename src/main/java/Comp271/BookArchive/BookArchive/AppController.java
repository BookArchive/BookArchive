package Comp271.BookArchive.BookArchive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping(value ={"/","/home"})
public class AppController {

    @GetMapping("/")
    public String home(){
        return "home.html";
    }

}
