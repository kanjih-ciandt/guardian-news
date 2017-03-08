package com.kanjih.guardian_news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kanjih.guardian_news.R;
import com.kanjih.guardian_news.to.News;

import java.util.List;

/**
 * Created by kneto on 3/8/17.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, int resource, List<News> news) {
        super(context, resource, news);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News news = getItem(position);
        TextView section = (TextView) convertView.findViewById(R.id.li_section);
        TextView date = (TextView) convertView.findViewById(R.id.li_date_new);
        TextView title = (TextView) convertView.findViewById(R.id.li_title);
        TextView type = (TextView) convertView.findViewById(R.id.li_type);

        section.setText(news.getSectionName());
        date.setText(news.getWebPublicationDate());
        title.setText(news.getWebTitle());
        type.setText(news.getType());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }
}
