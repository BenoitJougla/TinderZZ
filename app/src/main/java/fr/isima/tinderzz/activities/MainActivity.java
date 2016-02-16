package fr.isima.tinderzz.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.wenchao.cardstack.CardStack;

import java.util.ArrayList;
import java.util.List;

import fr.isima.tinderzz.R;
import fr.isima.tinderzz.listener.CardEventsListener;
import fr.isima.tinderzz.listener.MainActivityListener;
import fr.isima.tinderzz.model.DataManager;
import fr.isima.tinderzz.model.Result;
import fr.isima.tinderzz.model.Results;
import fr.isima.tinderzz.model.User;

public class MainActivity extends TinderActivity {

    String TAG = "MainActivity";
    CardStack mCardStack;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mCardStack.reset(true);
        mCardsDataAdapter.clear();

        List<Result> list = DataManager.getInstance().getResults().getList();

        for(int i = DataManager.getInstance().getCurrentIndex(); i < list.size() ; ++i) {
            mCardsDataAdapter.add(list.get(i));
        }

        Log.d(TAG, "On restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardStack = (CardStack)findViewById(R.id.cardStack);
        mCardStack.setContentResource(R.layout.card_layout);
        mCardStack.setAdapter(getCardsDataAdapter());

        Log.d(TAG, "onCreate");

        newRequest();

        final Button button = (Button) findViewById(R.id.nopeButton);
        button.setOnClickListener(new MainActivityListener(mCardStack, 0));

        final  Button likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new MainActivityListener(mCardStack, 3));

        mCardStack.setListener(new CardEventsListener(this));
    }

    public void updateView(User user) {
    }

    @Override
    public void refresh() {
        mCardStack.reset(true);
    }
}
