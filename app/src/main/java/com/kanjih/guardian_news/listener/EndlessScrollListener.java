package com.kanjih.guardian_news.listener;

import android.util.Log;
import android.widget.AbsListView;

import com.kanjih.guardian_news.MainActivity;

/**
 * Created by kneto on 3/8/17.
 */

public class EndlessScrollListener implements AbsListView.OnScrollListener {

    public static final String LOG_TAG = EndlessScrollListener.class.getName();

    private int firstVisibleItem = 1;

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
//      Log.i(LOG_TAG,"onScrollStateChanged. scrollState:" + scrollState );
        if (firstVisibleItem > 1 ){

            Log.i(LOG_TAG,"LOAD MORE. firstVisibleItem:"
                    + firstVisibleItem);
        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//        Log.i(LOG_TAG,"onScroll. firstVisibleItem:"
//                + firstVisibleItem + " visibleItemCount:" +  visibleItemCount
//                + " totalItemCount:" + totalItemCount);
        this.firstVisibleItem = firstVisibleItem;


    }
}
