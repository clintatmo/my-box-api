package sr.catmosoerodjo.services;

import sr.catmosoerodjo.models.User;

import java.util.List;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class UserService {

    public List<User> getAllUsers() {

        List<User> users = User.findAll();
        return users;
    }

    public User getUser(int id) {
        List<User> users = User.where("id = ?", id);
        return users.get(0);
    }

    public User createUser(String name, String email) {

        User p = new User();
        p.set("username", "Marilyn");
        p.set("password", "Monroe");
        p.saveIt();

        return null;
    }

    public User updateUser(String params, String name, String email) {

        User e = User.findFirst("username = ?", name);
        e.set("password", "Steinbeck").saveIt();

        return null;
    }
}
