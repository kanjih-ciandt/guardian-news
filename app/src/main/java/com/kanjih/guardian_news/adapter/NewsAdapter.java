package com.kanjih.guardian_news.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kanjih.guardian_news.R;
import com.kanjih.guardian_news.to.News;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by kneto on 3/8/17.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
    private SimpleDateFormat dateFormatOrigin = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");



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
        TextView about = (TextView) convertView.findViewById(R.id.li_about);
        TextView date = (TextView) convertView.findViewById(R.id.li_date);
        TextView title = (TextView) convertView.findViewById(R.id.li_title);
        TextView time = (TextView) convertView.findViewById(R.id.li_time);
        TextView icon = (TextView) convertView.findViewById(R.id.li_icon);

        try {
            Date datetime = dateFormatOrigin.parse(news.getWebPublicationDate());
            date.setText(dateFormat.format(datetime));
            time.setText(timeFormat.format(datetime));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        StringBuilder aboutBuilder = new StringBuilder().append(news.getType()).append(" about ").append(news.getSectionName());

        about.setText(aboutBuilder.toString().toLowerCase());
        title.setText(news.getWebTitle());

        String firstLetter = news.getSectionName().substring(0,1);
        icon.setText(firstLetter);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable iconCircle = (GradientDrawable) icon.getBackground();

        iconCircle.setColor(this.getIconColor(firstLetter));

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }

    private int getIconColor(String letter) {
        int colorResourceId;

        switch (letter){
            case "A":
                colorResourceId = R.color.colorA;
                break;
            case "B":
                colorResourceId = R.color.colorB;
                break;
            case "C":
                colorResourceId = R.color.colorC;
                break;
            case "D":
                colorResourceId = R.color.colorD;
                break;
            case "E":
                colorResourceId = R.color.colorE;
                break;
            case "F":
                colorResourceId = R.color.colorF;
                break;
            case "G":
                colorResourceId = R.color.colorG;
                break;
            case "H":
                colorResourceId = R.color.colorH;
                break;
            case "I":
                colorResourceId = R.color.colorI;
                break;
            case "J":
                colorResourceId = R.color.colorJ;
                break;
            case "K":
                colorResourceId = R.color.colorK;
                break;
            case "L":
                colorResourceId = R.color.colorL;
                break;
            case "M":
                colorResourceId = R.color.colorM;
                break;
            case "N":
                colorResourceId = R.color.colorN;
                break;
            case "O":
                colorResourceId = R.color.colorO;
                break;
            case "P":
                colorResourceId = R.color.colorP;
                break;
            case "Q":
                colorResourceId = R.color.colorQ;
                break;
            case "R":
                colorResourceId = R.color.colorR;
                break;
            case "S":
                colorResourceId = R.color.colorS;
                break;
            case "T":
                colorResourceId = R.color.colorT;
                break;
            case "U":
                colorResourceId = R.color.colorU;
                break;
            case "V":
                colorResourceId = R.color.colorV;
                break;
            case "X":
                colorResourceId = R.color.colorX;
                break;
            case "Y":
                colorResourceId = R.color.colorY;
                break;
            case "Z":
                colorResourceId = R.color.colorY;
                break;
            default:
                colorResourceId = R.color.colorZ;
                break;
        }

        return ContextCompat.getColor(getContext(),colorResourceId);
    }
}
