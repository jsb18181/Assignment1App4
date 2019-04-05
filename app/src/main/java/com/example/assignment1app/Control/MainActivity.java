package com.example.assignment1app.Control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.assignment1app.R;

/**
 * The main activity class which starts off the app and enables other activities to be launched.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The actions to be taken when the activity is created. Launches the main activity XML layout.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Launches the stack activity.
     *
     * @param v the stack activity view
     */
    public void stackButtonClick(View v) {

        Intent launchStack = new Intent(this, StackActivity.class);
        startActivity(launchStack);

    }

    /**
     * Launches the queue activity.
     *
     * @param v the queue activity view
     */
    public void queueButtonClick(View v) {

        Intent launchQueue = new Intent(this, QueueActivity.class);
        startActivity(launchQueue);
    }

    /**
     * Launches the bubble sort activity.
     *
     * @param v the bubble sort activity view
     */
    public void bubbleButtonClick(View v) {

        Intent launchBubble = new Intent(this, BubbleActivity.class);
        startActivity(launchBubble);
    }
}
