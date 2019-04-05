package com.example.assignment1app.Control;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * An abstract class which outlines a generic ViewHolder to by extended.
 *
 * @param <T>
 */
public abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
    private View view;
    private T item;

    /**
     * A constructor which initiates the views which will be inside the view in question.
     *
     * @param itemView the current view
     */
    protected ViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }

    /**
     * Returns the view in question.
     *
     * @return the view
     */
    public final View getView() {
        return view;
    }

    /**
     * A method to set the item in question.
     *
     * @param item the item to set
     */
    public final void setItem(T item) {
        this.item = item;
        onSetItem(item);
    }

    /**
     * An abstract method to be implemented, which can allow the colour and background details
     * of the item to be set.
     *
     * @param item the list item in question
     */
    protected abstract void onSetItem(T item);

}

