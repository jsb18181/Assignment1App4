package com.example.assignment1app.Control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.assignment1app.R;

/**
 * A class which extends the MyViewHolder class and enables a cardView to display the
 * necessary information.
 */
public class CardViewHolder extends MyViewHolder {
    public TextView name;
    public TextView course;
    public ImageView thumbnail;

    /**
     * A constructor which initiates the views which will be inside the cardView.
     *
     * @param itemView the current view
     */
    private CardViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.student_name);
        course = itemView.findViewById(R.id.student_course);
        thumbnail = itemView.findViewById(R.id.thumbnail);
    }

    /**
     * A method to create the card view holder within the current view group.
     *
     * @param viewGroup the current view group
     * @return a card view holder
     */
    public static CardViewHolder createHolder(ViewGroup viewGroup) {
        LayoutInflater viewInflater = LayoutInflater.from(viewGroup.getContext());
        View card = viewInflater.inflate(R.layout.card_layout, viewGroup, false);
        return new CardViewHolder(card);
    }
}