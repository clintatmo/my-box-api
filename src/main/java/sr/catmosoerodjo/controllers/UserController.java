package sr.catmosoerodjo.controllers;

import com.google.gson.Gson;
import sr.catmosoerodjo.services.UserService;
import sr.catmosoerodjo.utils.ResponseError;

import static spark.Spark.*;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class UserController {

    public UserController(final UserService userService) {

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

            }
        );

        }


    }
