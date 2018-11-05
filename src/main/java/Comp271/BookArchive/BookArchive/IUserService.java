package Comp271.BookArchive.BookArchive;

import Comp271.BookArchive.BookArchive.DataModels.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserService {

    List<User> findAll();
    User save(User u);
    List<User> findByUsername(String username);
    User deleteUser(User u);

}
