package com.matrix_maeny.sudokugame.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.matrix_maeny.sudokugame.R;
import com.matrix_maeny.sudokugame.adapters.LevelsAdapter;
import com.matrix_maeny.sudokugame.databases.LevelsDataBase;
import com.matrix_maeny.sudokugame.models.LevelModel;

import java.util.ArrayList;
import java.util.Objects;

public class Sudoku9x9LevelsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LevelsAdapter adapter;
    ArrayList<LevelModel> list;
    TextView levelHeading;

    LevelsDataBase levelsDataBase = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_sudoku_levels);

        Objects.requireNonNull(getSupportActionBar()).hide();

        recyclerView = findViewById(R.id.recyclerLevelsView);
        levelHeading = findViewById(R.id.sudokuLevelHeading);
        levelHeading.setText(R.string._9x9Levels);

        list = new ArrayList<>();
        adapter = new LevelsAdapter(Sudoku9x9LevelsActivity.this, list, 1);

        loadTheLevels();

        recyclerView.setAdapter(adapter);
        setTheLayout();
    }

    private void setTheLayout() {
        recyclerView.setLayoutManager(new GridLayoutManager(Sudoku9x9LevelsActivity.this, 4));
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadTheLevels() {
        list.clear();
        levelsDataBase = new LevelsDataBase(Sudoku9x9LevelsActivity.this);
        Cursor cursor = levelsDataBase.getData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Levels not created: contact Matrix", Toast.LENGTH_SHORT).show();
            return;
        }

        cursor.moveToNext(); // going to 9x9 row
        int[] levelImage = {R.drawable.ic_baseline_lock_24, R.drawable.ic_baseline_lock_open_24};

        for (int i = 1; i < 21; i++) {
            int x = cursor.getInt(i);
            list.add(new LevelModel(x, levelImage[x]));
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onStart() {
        loadTheLevels();
        setTheLayout();
        super.onStart();

    }

    @Override
    protected void onResume() {
        loadTheLevels();
        setTheLayout();
        super.onResume();
    }
}