package sr.catmosoerodjo;

import org.pac4j.core.config.Config;
import sr.catmosoerodjo.config.CustomConfigFactory;
import sr.catmosoerodjo.controllers.AuthenticationController;
import sr.catmosoerodjo.controllers.UserController;
import sr.catmosoerodjo.controllers.WelcomeController;
import sr.catmosoerodjo.services.UserService;
import sr.catmosoerodjo.utils.Constant;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class Application {

    public static void main(String[] args) {

        final Config config = new CustomConfigFactory(Constant.JWT_SALT).build();

        new WelcomeController();
        new AuthenticationController(new UserService(), config);
        new UserController(new UserService(), config);

        //Base.close();

    }
}
