package fr.isima.tinderzz.model;

/**
 * Created by bejougla1 on 03/02/2016.
 */
public class DataManager {
    private Results results;
    private static DataManager _INSTANCE = null;

    private DataManager() {
        results = new Results();
    }

    public static DataManager getInstance() {
        if(_INSTANCE == null) {
            synchronized (DataManager.class) {
                if(_INSTANCE == null) {
                    _INSTANCE = new DataManager();
                }
            }
        }

        return _INSTANCE;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public Result next() {
        return results.next();
    }

    public Result getResult() {
        return results.getResult();
    }

    public boolean hasNext() {
        return results.hasNext();
    }

    public int getCurrentIndex() {
        return results.getCurrentIndex();
    }
}
