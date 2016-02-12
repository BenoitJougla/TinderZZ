package fr.isima.tinderzz.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bejougla1 on 27/01/2016.
 */
public class User implements Serializable {
    private String gender;
    private Name name;
    private Picture picture;
    private long dob;
    private String email;
    private Location location;

    public long getAge() {
        return (new Date().getTime()/1000 - dob) / 31556952;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location.toString();
    }

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Picture getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getName().first).append(" ").append(getName().last).append(", ").append(getAge()).append(" ans");

        return str.toString();
    }
}
