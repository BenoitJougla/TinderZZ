package fr.isima.tinderzz.listener;

import android.content.Intent;
import android.util.Log;

import com.wenchao.cardstack.CardStack;

import fr.isima.tinderzz.activities.DetailActivity;
import fr.isima.tinderzz.activities.TinderActivity;
import fr.isima.tinderzz.model.DataManager;
import fr.isima.tinderzz.model.Location;

/**
 * Created by Benoit on 12/02/2016.
 */
public class CardEventsListener implements CardStack.CardEventListener {

    private static String TAG = "CardEventsListener";
    private TinderActivity activity;

    public CardEventsListener(TinderActivity activity) {
        this.activity = activity;
    }

    //implement card event interface
    @Override
    public boolean swipeEnd(int direction, float distance) {
        //if "return true" the dismiss animation will be triggered
        //if false, the card will move back to stack
        //distance is finger swipe distance in dp

        //the direction indicate swipe direction
        //there are four directions
        //  0  |  1
        // ----------
        //  2  |  3

        return (distance>300)? true : false;
    }

    @Override
    public boolean swipeStart(int direction, float distance) {

        return true;
    }

    @Override
    public boolean swipeContinue(int direction, float distanceX, float distanceY) {

        return true;
    }

    @Override
    public void discarded(int id, int direction) {
        //this callback invoked when dismiss animation is finished.
        if(DataManager.getInstance().hasNext()) {
            DataManager.getInstance().next();
        } else {
            activity.newRequest();
        }
        Log.d(TAG, "Discarded id : " + id + " direction : " + direction);
    }

    @Override
    public void topCardTapped() {
        //this callback invoked when a top card is tapped by user.
        Intent i = new Intent(activity , DetailActivity.class);
        activity.startActivity(i);
    }
}
