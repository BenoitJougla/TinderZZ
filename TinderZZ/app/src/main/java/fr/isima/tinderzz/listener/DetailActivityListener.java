package fr.isima.tinderzz.listener;

import android.view.View;

import fr.isima.tinderzz.activities.TinderActivity;
import fr.isima.tinderzz.model.DataManager;

/**
 * Created by bejougla1 on 03/02/2016.
 */
public class DetailActivityListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        TinderActivity activity = (TinderActivity)v.getContext();
        if(DataManager.getInstance().hasNext()) {
            activity.updateView(DataManager.getInstance().next().getUser());
        } else {
            activity.newRequest();
        }
    }

}
