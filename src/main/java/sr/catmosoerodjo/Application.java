package sr.catmosoerodjo;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import sr.catmosoerodjo.controllers.UserController;
import sr.catmosoerodjo.controllers.WelcomeController;
import sr.catmosoerodjo.services.UserService;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class Application {

    public static void main(String[] args) {

        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/my-box-db", "loanmanagement", "loanmanagement");
        new DB("my-box-db").open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/my-box-db", "loanmanagement", "loanmanagement");

        new WelcomeController();
        new UserController(new UserService());

        Base.close();

    }
}
