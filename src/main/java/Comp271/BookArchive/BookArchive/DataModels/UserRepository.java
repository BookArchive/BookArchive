package Comp271.BookArchive.BookArchive.DataModels;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findUserByUsername(String username);
}
