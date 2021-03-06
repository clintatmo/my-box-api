package sr.catmosoerodjo.controllers;

import com.google.gson.Gson;
import org.pac4j.core.config.Config;
import org.pac4j.sparkjava.CallbackRoute;
import org.pac4j.sparkjava.RequiresAuthenticationFilter;
import spark.Route;
import sr.catmosoerodjo.services.UserService;
import sr.catmosoerodjo.utils.ResponseError;

import static spark.Spark.*;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class UserController {

    public UserController(final UserService userService, Config config) {

        final Route callback = new CallbackRoute(config);
        get("/callback", callback);
        post("/callback", callback);

        before("/users", new RequiresAuthenticationFilter(config, "ParameterClient"));
        get("/users", (req, res) -> userService.getAllUsers());

        get("/users/:id", (req, res) -> {
            String id = req.params(":id");
            String user = userService.getUser(Integer.valueOf(id));
            if (user != null) {
                return user;
            }
            res.status(400);
            return new Gson().toJson(new ResponseError("No user with id '%s' found", id));
        });

        post("/users", (req, res) -> {

            Boolean valid = userService.createUser(
                    req.queryParams("username"),
                    req.queryParams("password"));

            if (valid) {
                res.status(200);
                return null;
            }
            res.status(400);
            return new Gson().toJson(new ResponseError("User not created"));

        });

        put("/users/:id", (req, res) -> {
            Boolean valid = userService.updateUser(
                    req.params(":id"),
                    req.queryParams("username"),
                    req.queryParams("password"));

            if (valid) {
                res.status(200);
                return null;
            }
            res.status(400);
            return new Gson().toJson(new ResponseError("User not updated"));

        });

    }


}