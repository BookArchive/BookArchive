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

        List<Book> books = (List<Book>) bookService.findAll();
        return books;
    }

    @GetMapping("/api/user")
    public List<User> apiUser(){
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("/error")
    public String error(){
        return "404";
    }
}
