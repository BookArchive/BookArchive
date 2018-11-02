package Comp271.BookArchive.BookArchive;

import Comp271.BookArchive.BookArchive.DataModels.Book;
import Comp271.BookArchive.BookArchive.DataModels.User;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value="api/books/booksbytitle",method=RequestMethod.POST)
    @ResponseBody
    public String booksbytitle(){
        return "booksbytitle";
    }

    @RequestMapping(value="api/books/booksbyclass",method=RequestMethod.POST)
    @ResponseBody
    public String booksbyclass(){
        return "booksbyclass";
    }

    @GetMapping("/api/user")
    public User apiUser(){
        User user = new User("theReal_catLover","Underwater Basket Weaving");
        return user;
        /*
        User will have the ability to return values for both username and major
        The server must understand the following values and interpret them via an api route
        Following data could be held for a user and major.

        **Ideas at the moment not finalized yet**

        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException {
          try{
            User credentials = new uInformation().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getUsername(),
                        credentials.getPassword(),
                        new ArrayList<>())
        }
        */

        /*

         */

    }

    @GetMapping("/error")
    public String error(){
        return "404";
    }
}
