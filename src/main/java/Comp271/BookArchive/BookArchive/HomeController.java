package Comp271.BookArchive.BookArchive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
    Main Route Controller for the Application
 */
@RestController
public class HomeController {

    // GET home
    @GetMapping("/")
    public String HTML(){
        return "<H1>Book Archive Homepage</H1>"; // TODO: replace return value with static files(HTML/CSS/Javascript)
    }
}
