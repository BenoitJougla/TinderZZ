package fr.isima.tinderzz.model;

/**
 * Created by bejougla1 on 03/02/2016.
 */
public class Location {
    String street;
    String city;
    int zip;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(street).append(" ").append(zip).append(" ").append(city);
        return sb.toString();
    }
}