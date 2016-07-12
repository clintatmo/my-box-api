package sr.catmosoerodjo.services;

import sr.catmosoerodjo.models.User;

import java.util.List;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class UserService {

    public List<User> getAllUsers() {

        List<User> users = User.where("name = 'John'");
        return users;
    }

    public User getUser(String id) {
        List<User> users = User.where("id = ?", id);
        return users.get(0);
    }

    public User createUser(String name, String email) {

        User p = new User();
        p.set("name", "Marilyn");
        p.set("last_name", "Monroe");
        p.set("dob", "1935-12-06");
        p.saveIt();

        return null;
    }

    public User updateUser(String params, String name, String email) {

        User e = User.findFirst("name = ?", name);
        e.set("last_name", "Steinbeck").saveIt();

        return null;
    }
}
