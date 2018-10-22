package Comp271.BookArchive.BookArchive;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

/*
This Class is A route controller example. It does not need a constructor because Spring doesn't care about the class
instance so much as it cares about the individual methods in it used to handle the HTTP routes. It does this through
java annotations seen ex: "@GetMapping". Also the JSONObject class is from a separate dependency
(link included in the pom.xml file). It allows you to create JSON objects easily from java params.

This follows the example from: https://spring.io/guides/tutorials/rest/
 */

@RestController
public class TestController {


    //example of creating request handler the long way
    @RequestMapping(value = "/",method = RequestMethod.GET, produces ="application/json" )
    public JSONObject home(){
        JSONObject ob = new JSONObject();
        ob.put("hello","world");
        return ob;
    }

    // short version of a GET request
    @GetMapping("/page")
    public String page(){

        return "Success";
    }

    //shortcut for POST request
    @PostMapping("/postExample")
    public String postForExample(@RequestBody ExampleStudent student){
        // example for creating JSON with JSONObject but you can also jsut return the java object too
        JSONObject obj = new JSONObject();
        obj.put("name", student.name);
        obj.put("grade", student.grade);
        return obj.toJSONString();
    }

}
