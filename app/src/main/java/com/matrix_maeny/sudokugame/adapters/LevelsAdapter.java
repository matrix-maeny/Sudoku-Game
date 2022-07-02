package com.matrix_maeny.sudokugame.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matrix_maeny.sudokugame.R;
import com.matrix_maeny.sudokugame.activities.Sudoku12x12GameActivity;
import com.matrix_maeny.sudokugame.activities.Sudoku15x15GameActivity;
import com.matrix_maeny.sudokugame.activities.Sudoku9x9GameActivity;
import com.matrix_maeny.sudokugame.databases.LevelsDataBase;
import com.matrix_maeny.sudokugame.models.LevelModel;

import java.util.ArrayList;

public class LevelsAdapter extends RecyclerView.Adapter<LevelsAdapter.viewHolder> {

    Context context;
    ArrayList<LevelModel> list;
    int gameNumber;
    LevelsDataBase levelsDataBase = null;

    public LevelsAdapter(Context context, ArrayList<LevelModel> list, int gameNumber) {
        this.context = context;
        this.list = list;
        this.gameNumber = gameNumber;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.levels_model, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        LevelModel model = list.get(position);

        holder.levelStatusImage.setImageResource(model.getLevelStateImage());

        if (model.getState() == 1) {
            holder.levelLayout.setBackgroundResource(R.drawable.sub_level_model_background);
        } else {
            holder.levelLayout.setBackgroundResource(R.drawable.main_model_background);
        }

        holder.levelLayout.setOnClickListener(v -> {
            if (checkLevelStatus(gameNumber, holder.getAdapterPosition())) {
                changeToGameActivity(holder.getAdapterPosition());
            } else
                Toast.makeText(context.getApplicationContext(), "Please Unlock previous Levels", Toast.LENGTH_SHORT).show();

        });
    }

    private boolean checkLevelStatus(int gameNumber, int levelNumber) {

        levelsDataBase = new LevelsDataBase(context.getApplicationContext());
        Cursor cursor = levelsDataBase.getData();

        if (cursor.getCount() != 0) {

            for (int i = 0; i < gameNumber; i++) {
                cursor.moveToNext();
            }

            int status = cursor.getInt(levelNumber + 1);

            return status == 1;

        }

        return false;

    }

    private void changeToGameActivity(int levelNumber) {
        Intent intent = null;

        switch (gameNumber) {
            case 1:
                intent = new Intent(context.getApplicationContext(), Sudoku9x9GameActivity.class);
                break;
            case 2:
                intent = new Intent(context.getApplicationContext(), Sudoku12x12GameActivity.class);
                break;
            case 3:
                intent = new Intent(context.getApplicationContext(), Sudoku15x15GameActivity.class);

        }

        if (intent != null) {
            intent.putExtra("levelNumber", levelNumber);
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        ImageView levelStatusImage;
        LinearLayout levelLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            levelStatusImage = itemView.findViewById(R.id.levelStateImageView);
            levelLayout = itemView.findViewById(R.id.levelLayout);
        }
    }

}
