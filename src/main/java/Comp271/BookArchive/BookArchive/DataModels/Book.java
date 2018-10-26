package Comp271.BookArchive.BookArchive.DataModels;

import javax.annotation.Generated;

public class Book {

    private long id;
    private String title;
    private String author;
    private String subject;
    private int classNum;


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
}
