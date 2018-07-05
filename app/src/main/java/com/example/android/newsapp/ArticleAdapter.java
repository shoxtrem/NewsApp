package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(@NonNull Context context, int resource, @NonNull List<Article> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the article at the given position in the list of articles
        Article currentArticle = getItem(position);

        // Find the TextView with view ID web_title
        TextView webTitleView = listItemView.findViewById(R.id.web_title);
        String webTitle = currentArticle.getWebTitle();
        // Display the title of the current article in that TextView
        webTitleView.setText(webTitle);

        // Find the TextView with view ID section_name
        TextView sectionNameView = listItemView.findViewById(R.id.section_name);
        String sectionName = currentArticle.getSectionName();
        // Display the contributor of the current article in that TextView
        sectionNameView.setText(sectionName);

        // Find the TextView with view ID contributor
        TextView contributorView = listItemView.findViewById(R.id.contributor);
        StringBuilder concatenatedContributorNames = new StringBuilder();
        // Loop through the list and get all the authors
        ArrayList<String> contributors = getItem(position).getContributor();
        for (int i = 0; i < contributors.size(); i++) {
            concatenatedContributorNames.append(contributors.get(i));
            if (i < contributors.size() - 1) concatenatedContributorNames.append(", ");
        }
        contributorView.setText(concatenatedContributorNames.toString());

        // Create a new SimpleDateFormat object with correct pattern
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.getDefault());

        try {
            // Parse the String containing the date into a Date object.
            Date myDate = myFormat.parse(currentArticle.getWebPublicationDate());
            // Find the TextView with view ID date
            TextView dateView = listItemView.findViewById(R.id.date);
            // Format the date string (i.e. "Mar 3, 1984")
            // Display the date of the current article in that TextView
            dateView.setText(formatDate(myDate));

            // Find the TextView with view ID time
            TextView timeView = listItemView.findViewById(R.id.time);
            // Format the time string (i.e. "4:30PM")
            // Display the time of the current article in that TextView
            timeView.setText(formatTime(myDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.getDefault());
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.getDefault());
        return timeFormat.format(dateObject);
    }

}
