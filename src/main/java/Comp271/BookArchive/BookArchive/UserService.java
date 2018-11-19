package Comp271.BookArchive.BookArchive;


import Comp271.BookArchive.BookArchive.DataModels.User;
import Comp271.BookArchive.BookArchive.DataModels.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll(){
        return (List<User>) repository.findAll();
    }

    @Override
    public User save(User u){
        return  repository.save(u);
    }

    @Override
    public List<User> findByUsername(String username){
        return repository.findUserByUsername(username);
    }

    @Override
    public User deleteUser(User u){
        try{
            repository.delete(u);
        }catch(Exception e){
            return u;
        }
        return null;
    }

}
