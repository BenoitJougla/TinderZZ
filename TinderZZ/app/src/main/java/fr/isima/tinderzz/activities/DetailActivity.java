package fr.isima.tinderzz.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.isima.tinderzz.R;
import fr.isima.tinderzz.listener.DetailActivityListener;
import fr.isima.tinderzz.model.DataManager;
import fr.isima.tinderzz.model.Result;
import fr.isima.tinderzz.model.User;

public class DetailActivity extends TinderActivity {

    String TAG = "DETAIL_ACTIVITY";
    private TextView nameLabel;
    private TextView ageLabel;
    private TextView emailLabel;
    private TextView locationLabel;
    private ImageView imageField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        nameLabel = (TextView) findViewById(R.id.name);
        ageLabel = (TextView) findViewById(R.id.age);
        emailLabel = (TextView) findViewById(R.id.email);
        locationLabel = (TextView) findViewById(R.id.location);
        imageField = (ImageView) findViewById(R.id.imageView);

        Result result = DataManager.getInstance().getResult();
        updateView(result.getUser());

        final Button button = (Button) findViewById(R.id.nopeButton);
        button.setOnClickListener(new DetailActivityListener());
        final  Button likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new DetailActivityListener());
    }

    public void updateView(User user) {
        nameLabel.setText(user.toString());
        ageLabel.setText(String.valueOf(user.getAge()));
        emailLabel.setText(user.getEmail());
        locationLabel.setText(user.getLocation());
        Picasso.with(DetailActivity.this).load(user.getPicture().large).into(imageField);

        StringBuilder sb = new StringBuilder();
        sb.append(user.getName());
        setTitle(sb);
    }
}
