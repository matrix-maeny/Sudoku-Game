package com.matrix_maeny.sudokugame.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matrix_maeny.sudokugame.R;
import com.matrix_maeny.sudokugame.activities.Sudoku12x12LevelsActivity;
import com.matrix_maeny.sudokugame.activities.Sudoku15x15LevelsActivity;
import com.matrix_maeny.sudokugame.activities.Sudoku9x9LevelsActivity;
import com.matrix_maeny.sudokugame.models.MainModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    ArrayList<MainModel> list;
    Context context;



    public MainAdapter(Context context, ArrayList<MainModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_view_model, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        MainModel model = list.get(position);
        holder.modelName.setText(model.getModelName());


        holder.layout.setOnClickListener(v -> {
            changeRequireActivity(holder.getAdapterPosition());
        });

    }


    private void changeRequireActivity(int activityNumber) {
        Intent intent = null;
        switch (activityNumber) {
            case 0:
                // go to 9x9 activity
                intent = new Intent(context.getApplicationContext(), Sudoku9x9LevelsActivity.class);
                break;
            case 1:
                // go to 12x12 activity
                intent = new Intent(context.getApplicationContext(), Sudoku12x12LevelsActivity.class);

                break;
            case 2:
                // go to 15x15 activity
                intent =new Intent(context.getApplicationContext(), Sudoku15x15LevelsActivity.class);
                break;
        }

        context.startActivity(intent);
    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView modelName;
        LinearLayout layout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            modelName = itemView.findViewById(R.id.mainModelName);
            layout = itemView.findViewById(R.id.mainModelLinearLayout);
        }
    }
}
