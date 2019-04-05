package com.example.assignment1app.Control;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment1app.R;

/**
 * A class which extends the MyViewHolder class and enables a textView to display the
 * necessary information.
 */
public class MyViewHolder extends ViewHolder<String> {
    private TextView listEntryView;

    /**
     * A constructor which initiates the views which will be inside the textView.
     *
     * @param itemView the current view
     */
    public MyViewHolder(View itemView) {
        super(itemView);
        listEntryView = getView().findViewById(R.id.listEntry);
    }

    /**
     * A method to create the view holder within the current view group.
     *
     * @param viewGroup the current view group
     * @return a view holder which holds list items
     */
    public static MyViewHolder createHolder(ViewGroup viewGroup) {
        LayoutInflater viewInflater = LayoutInflater.from(viewGroup.getContext());
        View listItemView = viewInflater.inflate(R.layout.list_items_holder, viewGroup, false);
        return new MyViewHolder(listItemView);
    }

    /**
     * A method to set the list item and alter the size and colour of the item in question.
     *
     * @param listItem the list item to set
     */
    @Override
    protected void onSetItem(String listItem) {
        listEntryView.setText(listItem);
        listEntryView.setTextSize(25);
        listEntryView.setTextColor(Color.rgb(0, 0, 0));
    }
}

