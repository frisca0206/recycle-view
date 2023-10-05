package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;

import android.os.Bundle;
import android.util.Log;

import java.util.Deque;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mWordList = new LinkedList<>();
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + mCount++);
            Log.d("WordList", mWordList.getLast());
        }
    }
}