package fr.isima.tinderzz.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.wenchao.cardstack.CardStack;

import fr.isima.tinderzz.R;
import fr.isima.tinderzz.listener.CardEventsListener;
import fr.isima.tinderzz.listener.MainActivityListener;
import fr.isima.tinderzz.model.DataManager;
import fr.isima.tinderzz.model.User;

public class MainActivity extends TinderActivity {

    CardStack mCardStack;
    String TAG = "MainActivity";
    int nbElementsToSynchronized = 0;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        nbElementsToSynchronized = DataManager.getInstance().getCurrentIndex() - mCardStack.getCurrIndex();
        Log.d(TAG, "onRestart position : " + nbElementsToSynchronized);

        for(int i = 0; i < nbElementsToSynchronized; ++i) {
            mCardStack.discardTop(0);
        }
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

       /* imageView.setOnClickListener(
                new View.DetailActivityListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this , DetailActivity.class);
                        startActivity(i);
                    }
                }
        );*/
    }

    public void updateView(User user) {

        if(nbElementsToSynchronized > 0)
            --nbElementsToSynchronized;

        if(nbElementsToSynchronized == 0) {
            if(DataManager.getInstance().hasNext()) {
                DataManager.getInstance().next();
            } else {
                newRequest();
            }
        }

        /*descriptionText.setText(user.toString());
        Picasso.with(MainActivity.this).load(user.picture.large).into(imageView);*/
    }
}
