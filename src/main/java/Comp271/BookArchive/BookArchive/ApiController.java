package Comp271.BookArchive.BookArchive;

import Comp271.BookArchive.BookArchive.DataModels.Book;
import Comp271.BookArchive.BookArchive.DataModels.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Main Route Controller for the Application
 */
@RestController
public class ApiController {

    /*// GET home
    @GetMapping("/")
    public ModelAndView HTML(){
        //return "<H1>Book Archive Homepage</H1>"; // TODO: replace return value with static files(HTML/CSS/Javascript)
        return new ModelAndView("src/main/resources/static/home.html");
    }*/

    @GetMapping("/api/books")
    public Book[] apiBook(){

        Book[] arr = {new Book("Programming for Dummies","John Doe","COMP",170),
                new Book("Useless English Book","Some Guy","ENGL",102)};

        return arr;
    }

    @GetMapping("/api/user")
    public User apiUser(){
        User user = new User("theReal_catLover","Underwater Basket Weaving");
        return user;
    }

    @GetMapping("/error")
    public String error(){
        return "404";
    }
}
