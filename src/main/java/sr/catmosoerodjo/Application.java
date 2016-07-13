package sr.catmosoerodjo;

import sr.catmosoerodjo.controllers.UserController;
import sr.catmosoerodjo.controllers.WelcomeController;
import sr.catmosoerodjo.services.UserService;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class Application {

    public static void main(String[] args) {

        //Base.open("com.mysql0.jdbc.Driver", "jdbc:mysql://localhost:3306/my-box-db", "root", "root");

        new WelcomeController();
        new UserController(new UserService());

        //Base.close();

    }
}
