package Comp271.BookArchive.BookArchive.DataModels;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findByTitle(@Param("title") String title);
    public List<Book> findByClass(@Param("subject") String subject, @Param("classNum") int classNum);
}
