package fr.isima.tinderzz.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.isima.tinderzz.R;

/**
 * Created by bejougla1 on 03/02/2016.
 */
public class CardsDataAdapter extends ArrayAdapter<Result> {

    public CardsDataAdapter(Context context, int resource, List<Result> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, final View contentView, ViewGroup parent){

        TextView descriptionText = (TextView)contentView.findViewById(R.id.description);
        ImageView imageView = (ImageView)contentView.findViewById(R.id.imageView);

        Result result = getItem(position);

        descriptionText.setText(result.getUser().toString());
        Picasso.with(contentView.getContext()).load(result.getUser().getPicture().large).into(imageView);

        return contentView;
    }

}