package Comp271.BookArchive.BookArchive.DataModels;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
