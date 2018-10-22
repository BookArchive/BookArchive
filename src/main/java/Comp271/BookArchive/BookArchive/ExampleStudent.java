package Comp271.BookArchive.BookArchive;

/*
This is the model class for the POST request example listed in the TestController Class
There are no special requirements for your own classes to work in HTTP request handler methods
other than your class has to have a default constructor and the member variable names have to match all of the key names
in the JSON object sent.

NOTE: if the member variables are private, they have to have getter and setter methods.
 */
public class ExampleStudent {

    /*
    JSON that this class can digest:  { "name : "Some string value", "grade" : "Some string value" }
     */

    public String name;
    public String grade;

    public ExampleStudent(){} //default constructor so that Request hanlers can use

    /*
       other constructors and methods do not matter, when JSON parsed, only the object properties will be set as
       if the below constructor was called
     */

    public ExampleStudent(String name, String grade){
        this.name = name;
        this.grade = grade;
    }
}
