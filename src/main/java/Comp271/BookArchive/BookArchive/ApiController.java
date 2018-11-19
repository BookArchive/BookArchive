package Comp271.BookArchive.BookArchive;


import Comp271.BookArchive.BookArchive.DataModels.Book;
import Comp271.BookArchive.BookArchive.DataModels.BookRepository;
import Comp271.BookArchive.BookArchive.DataModels.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.List;



/*
    Main Route Controller for the Application
 */
@RestController
public class ApiController {


    @Autowired
    IBookService bookService;

    @Autowired
    IUserService userService;

    @PostMapping("/api/savebook")
    public Book saveBook(@RequestBody Book b){
        System.out.println();
        return bookService.save(b);
    }

    @PostMapping("/api/deleteuser")
    public User deleteUser(@RequestBody User u){
        System.out.println();
        User temp =  userService.findByUsername(u.getUsername()).get(0);


        return userService.deleteUser(temp);
    }

    @PostMapping("/api/saveuser")
    public User saveBook(@RequestBody User u){
        if(userService.findByUsername(u.getUsername()).size()<1){
            return userService.save(u);
        }
       else{
           return new User("USERNAME ALREADY EXISTS", "ERROR");
        }


    }

    @GetMapping("/api/books")
    public List<Book> apiBook(){

        Book[] arr = {new Book("Programming for Dummies","John Doe","COMP",170),
                new Book("Useless English Book","Some Guy","ENGL",102)};
        return arr;

    }
    @RequestMapping(value="api/books/booksbytitle",method=RequestMethod.POST)
    @ResponseBody
    public Book[] booksbytitle(){
        Book[] arr= {new Book("Programming for Dummies","John Doe","COMP",170),
                new Book("Useless English Book","Some Guy","ENGL",102)};
        return arr;
    }

    @RequestMapping(value="api/books/booksbyclass",method=RequestMethod.POST)
    @ResponseBody
    public Book[] booksbyclass(){
        Book[] arr= {new Book("Programming for Dummies","John Doe","COMP",170),
                new Book("Useless English Book","Some Guy","ENGL",102)};
        return arr;
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


        List<Book> books = (List<Book>) bookService.findAll();
        return books;
    }

    }

    @GetMapping("/error")
    public String error(){
        return "404";
    }
}
