package com.example.assignment1app.Control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment1app.Model.StackArray;
import com.example.assignment1app.Model.Student;
import com.example.assignment1app.R;

/**
 * A class which controls the stack user interface.
 */
public class StackActivity extends AppCompatActivity {

    private StackArray stack;
    private MyStackAdapter recyclerViewAdapter;
    private EditText editText3;
    private EditText editText4;
    private RecyclerView recyclerView;
    private Animate animate;

    /**
     * The actions to be taken when the activity is created. Launches the stack activity XML layout.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        animate = new Animate();
        recyclerViewAdapter = new MyStackAdapter();
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        stack = new StackArray();
        recyclerView = findViewById(R.id.my_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * Controls the actions taken when the push button is clicked in the stack activity.
     * Returns applicable message in the form of toast.
     *
     * @param v the view in question
     */
    public void pushButton(View v) {
        String nameToPush = editText3.getText().toString();
        String courseToPush = editText4.getText().toString();

        if (nameToPush.isEmpty() || courseToPush.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter a student to push", Toast.LENGTH_SHORT).show();
        } else {
            Student student = new Student(courseToPush, nameToPush);
            stack.push(student);
            animate.animate(recyclerView);
            recyclerViewAdapter.notifyDataSetChanged();
        }
    }

    /**
     * Controls the actions taken when the pop button is clicked in the stack activity.
     * Returns applicable message in the form of toast.
     *
     * @param v the view in question
     */
    public void popButton(View v) {
        if (stack.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Stack is empty, cannot pop", Toast.LENGTH_SHORT).show();
        } else {
            stack.pop();
            recyclerViewAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Popped!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Controls the actions taken when the top button is clicked in the stack activity.
     * Returns applicable message in the form of toast.
     *
     * @param v the view in question
     */
    public void topButton(View v) {
        if (stack.isEmpty()) {
            Toast.makeText(getApplicationContext(), "The stack is currently empty", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), stack.top().getName() + " is currently top of the stack", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Controls the actions taken when the search button is clicked in the stack activity.
     * Returns applicable message in the form of toast.
     *
     * @param v the view in question
     */
    public void searchButton(View v) {
        String nameToSearch = editText4.getText().toString();

        if (stack.isEmpty()) {
            Toast.makeText(getApplicationContext(), "The stack is currently empty", Toast.LENGTH_SHORT).show();
        } else {
            if (!nameToSearch.isEmpty()) {
                Toast.makeText(getApplicationContext(), "This student was found in position " + stack.search(nameToSearch), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please enter a name to search for", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class MyStackAdapter extends RecyclerView.Adapter<CardViewHolder> {

        /**
         * A constructor for the MyStackAdapter class.
         */
        public MyStackAdapter() {
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
            return stack.getStack().get(position).hashCode();
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
            Student student = stack.getStack().get(position);
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
            return stack.getStack().size();
        }
    }
}

