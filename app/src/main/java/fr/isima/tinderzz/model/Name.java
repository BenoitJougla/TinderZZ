package fr.isima.tinderzz.model;

import java.io.Serializable;

/**
 * Created by bejougla1 on 27/01/2016.
 */
public class Name implements Serializable {
    String first;
    String last;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(first).append(" ").append(last);
        return sb.toString();
    }
}
