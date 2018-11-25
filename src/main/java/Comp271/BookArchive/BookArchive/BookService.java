package Comp271.BookArchive.BookArchive;

import Comp271.BookArchive.BookArchive.DataModels.Book;
import Comp271.BookArchive.BookArchive.DataModels.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book>  findAll(){
        return (List<Book>) repository.findAll();
    }

    @Override
    public Book save(Book b){
        try {
            repository.save(b);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return b;
    }

    @Override
    public Book deleteBook(Book b){
        try{
            repository.delete(b);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return b;
        }
        return null;
    }

    @Override
    public List<Book> findByTitle(String title){
        try {
            return repository.findByTitle(title);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Book> findByClass(String subject,int classNum) {
        System.out.println(subject);

        try {
            return repository.findByClass(subject,classNum);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return null;
    }
}
