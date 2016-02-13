package fr.isima.tinderzz.listener;

import android.view.View;

import com.wenchao.cardstack.CardStack;

import fr.isima.tinderzz.activities.MainActivity;
import fr.isima.tinderzz.activities.TinderActivity;

/**
 * Created by Benoit on 12/02/2016.
 */
public class MainActivityListener implements View.OnClickListener {

    private int direction;
    private CardStack cardStack;

    public MainActivityListener(CardStack cardStack, int direction) {
        this.direction = direction;
        this.cardStack = cardStack;
    }

    @Override
    public void onClick(View v) {
        cardStack.discardTop(direction);
    }
}
