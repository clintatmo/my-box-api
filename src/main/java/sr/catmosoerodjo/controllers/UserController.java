package sr.catmosoerodjo.controllers;

import sr.catmosoerodjo.models.User;
import sr.catmosoerodjo.services.UserService;
import sr.catmosoerodjo.utils.ResponseError;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static sr.catmosoerodjo.utils.JsonUtil.json;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class UserController {

    public UserController(final UserService userService) {

        get("/users", (req, res) -> userService.getAllUsers(), json());

        get("/users/:id", (req, res) -> {
            String id = req.params(":id");
            User user = userService.getUser(Integer.valueOf(id));
            if (user != null) {
                return user;
            }
            res.status(400);
            return new ResponseError("No user with id '%s' found", id);
        }, json());

        post("/users", (req, res) -> userService.createUser(
                req.queryParams("username"),
                req.queryParams("password")
        ), json());

        put("/users/:id", (req, res) -> userService.updateUser(
                req.params(":id"),
                req.queryParams("username"),
                req.queryParams("password")
        ), json());

    }


}
