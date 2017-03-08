package com.kanjih.guardian_news;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kanjih.guardian_news.adapter.NewsAdapter;
import com.kanjih.guardian_news.listener.EndlessScrollListener;
import com.kanjih.guardian_news.loader.GuardianLoadAsyncTask;
import com.kanjih.guardian_news.to.News;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.key;
import static android.R.attr.x;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>>{

    public static final String LOG_TAG = MainActivity.class.getName();

    //http://content.guardianapis.com/search?from-date=2017-03-07&api-key=test
    private static final String REQUEST_URL = "http://content.guardianapis.com/search";

    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();


        if(isConnected) {
            getLoaderManager().initLoader(1, null, this);
            // Find a reference to the {@link ListView} in the layout

        }
    }




    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG, "onCreateLoader");
        Uri baseUri = Uri.parse(REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("from-date","2017-03-07");
        uriBuilder.appendQueryParameter("api-key", "test");
        uriBuilder.appendQueryParameter("page-size","25");
        return new GuardianLoadAsyncTask(this, uriBuilder.toString());

    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> newsList) {
        Log.i(LOG_TAG, "onLoadFinished");

        if (newsList != null && !newsList.isEmpty()) {
            updateUI(newsList);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        Log.i(LOG_TAG, "onLoaderReset");
        updateUI(new ArrayList<News>());
    }

    /**
     * update the adapters
     * @param newsList
     */
    private void updateUI(final List<News> newsList) {
        Log.i(LOG_TAG, "updateUI");

        adapter = new NewsAdapter(this,0,newsList);

        // Find a reference to the {@link ListView} in the layout
        final ListView newsListView = (ListView) findViewById(R.id.list);

        newsListView.setAdapter(adapter);
        newsListView.setOnScrollListener(new EndlessScrollListener());



    }
}
