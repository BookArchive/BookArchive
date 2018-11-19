package Comp271.BookArchive.BookArchive.DataModels;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findByTitle(String title);
    public List<Book> findByClass(String subject, int courseNum);
}
