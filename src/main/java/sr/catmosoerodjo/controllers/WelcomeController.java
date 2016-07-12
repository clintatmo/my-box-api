package sr.catmosoerodjo.controllers;

import static spark.Spark.get;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class WelcomeController {
    public WelcomeController(){

        get("/hello", (req, res) -> "Hello World");
    }


}
