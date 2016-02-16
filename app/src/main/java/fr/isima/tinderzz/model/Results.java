package fr.isima.tinderzz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bejougla1 on 27/01/2016.
 */
public class Results {

    private int currentIndex;
    private List<Result> results;

    public Results() {
        results = new ArrayList<>();
        currentIndex = 0;
    }

    public boolean hasNext() {
        return (currentIndex + 1) < results.size();
    }

    public Result next() {
        ++ currentIndex;
        return results.get(currentIndex);
    }

    public Result getResult() {
        return results.get(currentIndex);
    }

    public List<Result> getList() {
        return results;
    }

    public int getCurrentIndex() { return currentIndex; }
}
