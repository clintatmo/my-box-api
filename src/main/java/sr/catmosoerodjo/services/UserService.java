package sr.catmosoerodjo.services;

import org.javalite.activejdbc.DB;
import org.javalite.activejdbc.LazyList;
import sr.catmosoerodjo.models.User;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class UserService {

    public String getAllUsers() {

        new DB("my-box-db").open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/my-box-db", "root", "root");
        LazyList<User> users = User.findAll();
        String json = null;
        if(users != null){
            json = users.toJson(true);
        }
        new DB("my-box-db").close();

        return json;

    }

    public String getUser(Integer id) {

        new DB("my-box-db").open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/my-box-db", "root", "root");
        User user = User.findById(id);
        String json = null;
        if(user != null){
            json = user.toJson(true);
        }
        new DB("my-box-db").close();

        return json;
    }

    public boolean createUser(String username, String password) {

        new DB("my-box-db").open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/my-box-db", "root", "root");
        User p = new User();
        p.set("username", username);
        p.set("password", password);
        boolean createdUser = p.saveIt();
        new DB("my-box-db").close();

        return createdUser;
    }

    public boolean updateUser(String id, String username, String password) {

        new DB("my-box-db").open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/my-box-db", "root", "root");
        User e = User.findById(id);
        e.set("username", username);
        e.set("password", password);
        boolean updatedUser = e.saveIt();
        new DB("my-box-db").close();


        return updatedUser;
    }
}
