package com.example.recycleview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = new String();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String> mWordList = new LinkedList<>();
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < 2; i++) {
            mWordList.addLast("Baju " + mCount++);
            Log.d("WordList", mWordList.getLast());
        }

        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2, LinearLayoutManager.VERTICAL,false));

        // Add a floating action click handler for creating new entries.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                // Add a new word to the end of the wordList.
                mWordList.addLast("Test " + wordListSize);
                // Notify the adapter, that the data has changed so it can
                // update the RecyclerView to display the data.
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}