package sr.catmosoerodjo.services;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import sr.catmosoerodjo.models.User;

import java.util.List;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class UserService {

    public List<User> getAllUsers() {

        new DB("my-box-db").open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/my-box-db", "root", "root");

        List<User> users = User.findAll();

        new DB("my-box-db").close();

        return users;
    }

    public User getUser(int id) {

        new DB("my-box-db").open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/my-box-db", "root", "root");

        List<User> users = User.where("id = ?", id);

        new DB("my-box-db").close();

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
