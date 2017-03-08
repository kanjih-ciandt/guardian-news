package com.kanjih.guardian_news.loader;

import com.kanjih.guardian_news.bs.guardian.QueryUtils;
import com.kanjih.guardian_news.to.News;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by kneto on 3/8/17.
 */

public class GuardianLoadAsyncTask extends AsyncTaskLoader<List<News>> {

    String url;
    public static final String LOG_TAG = GuardianLoadAsyncTask.class.getName();


    public GuardianLoadAsyncTask(Context context, String url){
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "onStartLoading");
        forceLoad();
    }



    @Override
    public List<News> loadInBackground() {
        Log.i(LOG_TAG, "loadInBackground");

        List<News> newsList = QueryUtils.fetchData(url);

        return newsList;
    }
}
