package com.matrix_maeny.sudokugame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.matrix_maeny.sudokugame.activities.AboutActivity;
import com.matrix_maeny.sudokugame.adapters.MainAdapter;
import com.matrix_maeny.sudokugame.databases.LevelsDataBase;
import com.matrix_maeny.sudokugame.databases.SoundDataBase;
import com.matrix_maeny.sudokugame.dialogs.SoundDialog;
import com.matrix_maeny.sudokugame.models.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    private MainAdapter adapter;
    ArrayList<MainModel> list;

    LevelsDataBase levelsDataBase = null;

    private SoundDataBase soundDataBase = null;
    private String[] levelNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        levelNames = new String[]{
                getString(R.string.sudoku9x9),
                getString(R.string.sudoku12x12),
                getString(R.string.sudoku15x15)
        };

        recyclerView = findViewById(R.id.mainRecyclerView);

        list = new ArrayList<>();
        setTheItemsIntoList();

        adapter = new MainAdapter(MainActivity.this,list);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);

        setTheSubLevels();

        setTheSound();
    }

    private void setTheItemsIntoList(){

        list.add(new MainModel(getString(R.string.sudoku9x9)));
        list.add(new MainModel(getString(R.string.sudoku12x12)));
        list.add(new MainModel(getString(R.string.sudoku15x15)));
    }

    private void setTheSubLevels(){
        levelsDataBase = new LevelsDataBase(MainActivity.this);
        Cursor cursor = levelsDataBase.getData();


        if(cursor.getCount() == 0){
            for(int i=0;i<3;i++){
                if(!levelsDataBase.insertData(levelNames[i])){
                    Toast.makeText(this, "Error in creating sub levels: contact Matrix", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }


    private void setTheSound() {
        soundDataBase = new SoundDataBase(MainActivity.this);
        Cursor cursor = soundDataBase.getData();
        if (cursor.getCount() == 0) {
            if (!soundDataBase.insertData("MatrixSound", "enabled")) {
                Toast.makeText(this, "Error creating sound database: contact Matrix", Toast.LENGTH_SHORT).show();
            }
        }

        levelsDataBase.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                //goto settings dialog
                showDialog();
                break;
            case R.id.about:
                //go to about activity
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog() {
        SoundDialog dialog = new SoundDialog();
        dialog.show(getSupportFragmentManager(), "sound dialog");
    }

}