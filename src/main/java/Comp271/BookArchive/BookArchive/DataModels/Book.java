package Comp271.BookArchive.BookArchive.DataModels;

import ch.qos.logback.core.joran.spi.NoAutoStart;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name = "Book.findByTitle",query = "SELECT b FROM Book b WHERE b.title =:title"),
        @NamedQuery(name = "Book.findByClass",query = "SELECT b FROM Book b WHERE b.subject =:subject AND b.classNum =:classNum")})

@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    private String subject;
    private int classNum;
    private long ownerID;


    public  Book(){}

    public Book(String title, String author, String subject, int classNum){
        this.author = author;
        this.title = title;
        this.subject = subject;
        this.classNum = classNum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public int getClassNum() {
        return classNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwner() {
        return ownerID;
    }

    public void setOwner(long owner) {
        this.ownerID = owner;
    }

}
