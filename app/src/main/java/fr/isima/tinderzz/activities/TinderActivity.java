package fr.isima.tinderzz.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.ArrayList;

import fr.isima.tinderzz.model.CardsDataAdapter;
import fr.isima.tinderzz.model.DataManager;
import fr.isima.tinderzz.model.Result;
import fr.isima.tinderzz.model.Results;
import fr.isima.tinderzz.model.User;

/**
 * Created by bejougla1 on 03/02/2016.
 */
public abstract class TinderActivity extends AppCompatActivity {
    String TAG = "TinderActivity";
    final String url = "https://randomuser.me/api/?format=json&results=50&nat=fr";
    RequestQueue mRequestQueue;
    CardsDataAdapter mCardsDataAdapter;

    public abstract void updateView(User user);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);

        // Start the queue
        mRequestQueue.start();

        mCardsDataAdapter = new CardsDataAdapter(this,0, new ArrayList<Result>());
    }

    public void newRequest() {
        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);

                Gson gson = new Gson();
                mCardsDataAdapter.addAll(gson.fromJson(response, Results.class).getResults());
                DataManager.getInstance().setResults(gson.fromJson(response, Results.class));

                updateView(DataManager.getInstance().getResult().getUser());
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Network error :@");
            }
        });

        mRequestQueue.add(stringRequest);
    }

    public CardsDataAdapter getCardsDataAdapter() {
        return mCardsDataAdapter;
    }
}
