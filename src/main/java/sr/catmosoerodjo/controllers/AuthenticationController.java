package sr.catmosoerodjo.controllers;

import com.google.gson.Gson;
import org.pac4j.core.config.Config;
import org.pac4j.core.credentials.Credentials;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.profile.UserProfile;
import org.pac4j.http.profile.creator.ProfileCreator;
import org.pac4j.jwt.profile.JwtGenerator;
import org.pac4j.sparkjava.SparkWebContext;
import spark.Request;
import spark.Response;
import sr.catmosoerodjo.services.UserService;
import sr.catmosoerodjo.utils.Constant;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by clint on 7/13/16.
 */
public class AuthenticationController {
    public AuthenticationController(final UserService userService, Config config) {

        get("/jwt", AuthenticationController::jwt);

    }

    private static String jwt(Request request, Response response) {
        final UserProfile profile = getUserProfile(request, response);
        JwtGenerator generator = new JwtGenerator(Constant.JWT_SALT);
        String token = "";
        if (profile != null) {
            token = generator.generate(profile);
        }
        final Map map = new HashMap();
        map.put("token", token);
        return new Gson().toJson(map);
    }

    private static UserProfile getUserProfile(final Request request, final Response response) {

        UserProfile userProfile = new UserProfile();

        final SparkWebContext context = new SparkWebContext(request, response);
        final ProfileManager manager = new ProfileManager(context);

        return manager.get(true);
    }

}
