package com.example.keerthidhar.getsetgo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = Custom_Adapter.class.getSimpleName();


    public Custom_Adapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word current = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.location);
        nameTextView.setText(current.getMlocation());
        TextView capacity = (TextView) listItemView.findViewById(R.id.capacity);
        capacity.setText((current.getMcapacity()).toString());
        TextView entered = (TextView) listItemView.findViewById(R.id.entered);
        entered.setText((current.getMentered()).toString());
        TextView lef = (TextView) listItemView.findViewById(R.id.lef);
        lef.setText((current.getMleft()).toString());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView available = (TextView) listItemView.findViewById(R.id.available);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        available.setText((current.getMavailable()).toString());
        ProgressBar progressBar=(ProgressBar)listItemView.findViewById(R.id.prog);
        progressBar.setProgress(current.getMpercent());
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
