package com.example.assignment1app.Control;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.assignment1app.Model.BubbleSort;
import com.example.assignment1app.R;

/**
 * A class which controls the bubble sort user interface.
 */
public class BubbleActivity extends AppCompatActivity {

    private BubbleSort bubbleSort;
    private MyBubbleAdapter recyclerViewAdapter;
    private Animate animate;
    private RecyclerView recyclerView;
    private Handler handler;
    private Button bubbleSortButton, randomButton;

    /**
     * The actions to be taken when the activity is created. Launches the bubble activity XML layout.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble);

        animate = new Animate();
        recyclerViewAdapter = new MyBubbleAdapter();
        bubbleSort = new BubbleSort();
        bubbleSortButton = findViewById(R.id.button2);
        randomButton = findViewById(R.id.button);
        recyclerView = findViewById(R.id.my_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        handler = new Handler();
    }

    /**
     * A method which controls what happens when the random list button is clicked.
     * A random list is created and animated, then the adapted is notified of the changes to the list.
     * A toast message is then displayed to provide the used with some information.
     *
     * @param v the current View
     */
    public void randomListButton(View v) {
        bubbleSort.generateRandomArray();
        animate.animate(recyclerView);
        recyclerViewAdapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), "Random list generated", Toast.LENGTH_SHORT).show();
    }

    /**
     * A method which controls what happens when the bubble sort button is clicked.
     * The data will sort step by step, then the adapted is notified of the changes
     * at each stage of the sort, to enable the sorting to be animated.
     * A toast message is then displayed to provide the used with some information.
     *
     * @param v the current View
     */
    public void bubbleSortButton(View v) {

        bubbleSortButton.setClickable(false);
        randomButton.setClickable(false);
        Runnable runnable = () -> {
            for (int i = 0; i < bubbleSort.getArrayLength(); i++) {
                addDelay();
                for (int j = 1; j < bubbleSort.getArrayLength(); j++) {
                    addDelay();
                    bubbleSort.bubbleSortArray(j);
                    handler.post(() -> recyclerViewAdapter.notifyDataSetChanged());
                }
            }
        };
        new Thread(runnable).start();
        Toast.makeText(getApplicationContext(), "Bubble sort complete!", Toast.LENGTH_SHORT).show();
    }

    /**
     * A method which provides the ability to delay a process for a set amount of time.
     */
    public void addDelay() {

        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * A class which extends MyViewHolder. This class allows the bubble sort to be displayed in
     * a recyclerView.
     */
    private class MyBubbleAdapter extends RecyclerView.Adapter<MyViewHolder> {
        /**
         * A constructor for the MyBubbleAdapter class.
         */
        public MyBubbleAdapter() {
            super();
            setHasStableIds(true);
        }

        /**
         * Returns the hash value of the item in a specific position in the list.
         *
         * @param position the index position of the item
         * @return the hashCode of the item
         */
        @Override
        public long getItemId(int position) {
            return bubbleSort.getArray().get(position).hashCode();
        }

        /**
         * Creates the viewHolder and places it inside the correct viewGroup.
         *
         * @param viewGroup the viewGroup in question
         * @param viewType  the viewType which the holder should be placed in
         * @return the viewHolder
         */
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            return MyViewHolder.createHolder(viewGroup);
        }

        /**
         * Sets the item from the list into a specific holder in the recyclerView.
         *
         * @param holder   the viewHolder
         * @param position the position within the list
         */
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.setItem((bubbleSort.getArray().get(position).toString()));
        }

        /**
         * A method to show the number of items within the list.
         *
         * @return the number of values in the list
         */
        @Override
        public int getItemCount() {
            return bubbleSort.getArray().size();
        }
    }
}
