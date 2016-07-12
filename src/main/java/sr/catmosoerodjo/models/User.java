package sr.catmosoerodjo.models;

import org.javalite.activejdbc.Model;

/**
 * Created by catmosoerodjo on 7/10/16.
 */
public class User extends Model {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
