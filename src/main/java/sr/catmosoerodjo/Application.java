package sr.catmosoerodjo;

import org.javalite.activejdbc.Base;
import sr.catmosoerodjo.controllers.UserController;
import sr.catmosoerodjo.controllers.WelcomeController;
import sr.catmosoerodjo.services.UserService;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class Application {

    public static void main(String[] args) {

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "p@ssw0rd");

        new WelcomeController();
        new UserController(new UserService());

        Base.close();

    }
}
