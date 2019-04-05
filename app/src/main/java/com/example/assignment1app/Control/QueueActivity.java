package com.example.assignment1app.Control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.assignment1app.Model.QueueArray;
import com.example.assignment1app.Model.Student;
import com.example.assignment1app.R;

/**
 * A class which controls the queue user interface.
 */
public class QueueActivity extends AppCompatActivity {

    private QueueArray queueArray;
    private MyQueueAdapter recyclerViewAdapter;
    private EditText editText3;
    private EditText editText4;
    private RecyclerView recyclerView;
    private Animate animate;

    /**
     * The actions to be taken when the activity is created. Launches the queue activity XML layout.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        recyclerViewAdapter = new MyQueueAdapter();
        animate = new Animate();
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        queueArray = new QueueArray();
        recyclerView = findViewById(R.id.my_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    /**
     * Controls the actions taken when the enQueue button is clicked in the queue activity.
     * Returns applicable message in the form of toast.
     *
     * @param v the view in question
     */
    public void enQueueButton(View v) {
        String nameToEnqueue = editText3.getText().toString();
        String courseToEnqueue = editText4.getText().toString();

        if (nameToEnqueue.isEmpty() || courseToEnqueue.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter a student to enqueue", Toast.LENGTH_SHORT).show();
        } else {

            Student student = new Student(nameToEnqueue, courseToEnqueue);
            queueArray.enQueue(student);
            animate.animate(recyclerView);
            recyclerViewAdapter.notifyDataSetChanged();
        }
    }

    /**
     * Controls the actions taken when the deQueue button is clicked in the queue activity.
     * Returns applicable message in the form of toast.
     *
     * @param v the view in question
     */
    public void deQueueButton(View v) {
        if ((queueArray.getQueue()).isEmpty()) {
            Toast.makeText(getApplicationContext(), "Queue is empty, cannot dequeue", Toast.LENGTH_SHORT).show();
        } else {
            queueArray.deQueue();
            recyclerViewAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Dequeue successful!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Controls the actions taken when the front button is clicked in the queue activity.
     * Returns applicable message in the form of toast.
     *
     * @param v the view in question
     */
    public void frontButton(View v) {
        if ((queueArray.getQueue()).isEmpty()) {
            Toast.makeText(getApplicationContext(), "The queue is currently empty", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), queueArray.headOfQueue().getName() + " is currently head of the queue", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * A class which extends MyViewHolder. This class allows the queue to be displayed in
     * a recyclerView.
     */
    private class MyQueueAdapter extends RecyclerView.Adapter<CardViewHolder> {

        /**
         * A constructor for the MyQueueAdapter class.
         */
        public MyQueueAdapter() {
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
            return queueArray.getQueue().get(position).hashCode();
        }

        /**
         * Creates the viewHolder and places it inside the correct viewGroup.
         *
         * @param viewGroup the viewGroup in question
         * @param viewType  the viewType which the holder should be placed in
         * @return the viewHolder
         */
        @Override
        public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            return CardViewHolder.createHolder(viewGroup);
        }

        /**
         * Sets the item from the list into a specific holder in the recyclerView.
         *
         * @param cardViewHolder the viewHolder
         * @param position       the position within the list
         */
        @Override
        public void onBindViewHolder(CardViewHolder cardViewHolder, int position) {
            Student student = queueArray.getQueue().get(position);
            cardViewHolder.name.setText(student.getName());
            cardViewHolder.course.setText(student.getCourse());
            Glide.with(getApplicationContext()).load(R.drawable.student_pic).into(cardViewHolder.thumbnail);
        }

        /**
         * A method to show the number of items within the list.
         *
         * @return the number of values in the list
         */
        @Override
        public int getItemCount() {
            return queueArray.getQueue().size();
        }
    }
}
