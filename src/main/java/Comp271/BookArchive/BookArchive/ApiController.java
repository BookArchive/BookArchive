package Comp271.BookArchive.BookArchive;


import Comp271.BookArchive.BookArchive.DataModels.Book;
import Comp271.BookArchive.BookArchive.DataModels.BookRepository;
import Comp271.BookArchive.BookArchive.DataModels.User;
import Comp271.BookArchive.BookArchive.DataModels.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedQuery;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        System.out.println(b.getClassNum());
        return bookService.save(b);
    }

    @GetMapping("/api/DashboardData")
    public User dashboardUser(HttpServletRequest req){
        System.out.println("/DashboardData");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for(Cookie c : cookies){
                System.out.println(c.getName());
                if(c.getName().equals("RamblerReadsUser")){
                    User u = new User();
                    u.setUsername(c.getValue());
                    List<User> lOfUsers = userService.findByUsername(u.getUsername());
                    u = lOfUsers.get(0);
                    u.setPassword("");
                    return u;
                }
            }
        }
        return null;
    }

    @PostMapping("/api/login")
    public Boolean login(@RequestBody User u, HttpServletResponse response){
       System.out.println("login");
        List<User> check = userService.findByUsername(u.getUsername());
        if(check != null && check.size()>0){
            if(check.get(0).getPassword().equals(u.getPassword()) == true){
                Cookie cookie = new Cookie("RamblerReadsUser", check.get(0).getUsername());
                cookie.setMaxAge(3600*24);
               response.addCookie(cookie);
               return true;
            }
        }
        return false;
    }

    @GetMapping("/api/logout")
    public Boolean logout(HttpServletRequest req,HttpServletResponse res){
        System.out.println("logging out");
        Cookie[] cookies = req.getCookies();
        if(cookies.length>0){
            for(Cookie c : cookies){
                if(c.getName().equals("RamblerReadsUser")){
                    Cookie cookie = new Cookie("RamblerReadsUser", c.getValue());
                    cookie.setMaxAge(0);
                    res.addCookie(cookie);
                    return true;
                }
            }
        }
        return false;
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
        List<Book> books = (List<Book>) bookService.findAll();
        return books;
    }

    @PostMapping("/api/booksbyclass")
    public List<Book> apiBookByClass(@RequestBody Book b){
        return bookService.findByClass(b.getSubject(),b.getClassNum());
    }

    @PostMapping("/api/booksbytitle")
    public List<Book> apiBooksByTitle(@RequestBody Book b){
        return bookService.findByTitle(b.getTitle());
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
