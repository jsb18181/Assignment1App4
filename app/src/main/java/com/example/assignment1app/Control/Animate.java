package com.example.assignment1app.Control;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.assignment1app.R;

/**
 * A class which allows the animation of views that are in a recyclerView.
 */
public class Animate {

    /**
     * A method which uses an XML animation file to animate views to slide in from
     * the right hand side to the left hand side of a recyclerView.
     * @param recyclerView the recyclerView currently being used
     */
    public void animate(RecyclerView recyclerView)
    {
        Context context = recyclerView.getContext();
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slidefromright);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.scheduleLayoutAnimation();
    }
}
