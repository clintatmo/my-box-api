package sr.catmosoerodjo.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.DbName;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by catmosoerodjo on 7/10/16.
 */

@Table("user")
@DbName("my-box-db")
public class User extends Model {}
