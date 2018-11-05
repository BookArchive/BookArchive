package Comp271.BookArchive.BookArchive;

import Comp271.BookArchive.BookArchive.DataModels.Book;

import java.util.List;


public interface IBookService  {
    public List<Book> findAll();
    public Book save(Book b);
    public List<Book> findByTitle(String title);
    public List<Book> findByClass(String subject, int courseNum);
    public Book deleteBook(Book b);

}
