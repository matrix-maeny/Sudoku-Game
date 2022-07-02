package com.matrix_maeny.sudokugame.checkers;

import android.content.Context;
import android.widget.Toast;

public class MatrixChecker3 {
    int[][] matrix;
    Context context;

    public MatrixChecker3(Context context) {
        this.context = context;
        matrix = new int[15][15];

        for (int r = 0; r < 15; r++) {           // setting them to zero.. off-course it allocates but for safety..
            for (int c = 0; c < 15; c++) {
                matrix[r][c] = 0;
            }
        }

    }

    public boolean check(int row, int col) {
        if (this.matrix[row - 1][col - 1] > 0) {

            for (int i = 0; i < 15; i++) {
                if (this.matrix[i][col - 1] == this.matrix[row - 1][col - 1] && (row - 1) != i) {
                    this.matrix[row - 1][col - 1] = 0;
                    return false;
                }

                if (this.matrix[row - 1][i] == this.matrix[row - 1][col - 1] && (col - 1) != i) {

                    this.matrix[row - 1][col - 1] = 0;

                    return false;
                }
            }

            int boxRow = (row - 1) / 3;
            int boxCol = (col - 1) / 5;

            for (int r = boxRow * 3; r < (boxRow * 3) + 3; r++) {
                for (int c = boxCol * 5; c < (boxCol * 5) + 5; c++) {

                    if (this.matrix[r][c] == this.matrix[row - 1][col - 1] && (row - 1) != r && (col - 1) != c) {

                        this.matrix[row - 1][col - 1] = 0;
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean check2(int row, int col) {
        if (this.matrix[row - 1][col - 1] > 0) {

            for (int i = 0; i < 15; i++) {
                if (this.matrix[i][col - 1] == this.matrix[row - 1][col - 1] && (row - 1) != i) {
                    return false;
                }

                if (this.matrix[row - 1][i] == this.matrix[row - 1][col - 1] && (col - 1) != i) {


                    return false;
                }
            }

            int boxRow = (row - 1) / 3;
            int boxCol = (col - 1) / 5;

            for (int r = boxRow * 3; r < (boxRow * 3) + 3; r++) {
                for (int c = boxCol * 5; c < (boxCol * 5) + 5; c++) {

                    if (this.matrix[r][c] == this.matrix[row - 1][col - 1] && (row - 1) != r && (col - 1) != c) {

                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void setNumberPos(int num, int selectedRow, int selectedColumn) {
        if (selectedRow != -1 && selectedColumn != -1) {
            if (matrix[selectedRow - 1][selectedColumn - 1] == num) { // when you double click the button, the button gonna empty the box
                matrix[selectedRow - 1][selectedColumn - 1] = 0;
            } else {
                matrix[selectedRow - 1][selectedColumn - 1] = num; // or else if it is the single click... then set the number
            }
        }
    }

    private void tempToast(String m, int time) {
        if (time == 0) {
            Toast.makeText(context, m, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, m, Toast.LENGTH_LONG).show();

        }

    }
    public int checkSudokuStatus(){
        for (int r = 0; r <15; r++) {           // setting them to zero.. off-course it allocates but for safety..
            for (int c = 0; c <15; c++) {
                if(matrix[r][c]==0){
                    return 2;
                }
            }
        }

        for (int r = 1; r <=15; r++) {           // setting them to zero.. off-course it allocates but for safety..
            for (int c = 1; c <=15; c++) {
                if(!check2(r,c)){
                    return 0;
                }
            }
        }

        return 1;

    }

    public void resetBoard() {
        for (int r = 0; r < 15; r++) {
            for (int c = 0; c < 15; c++) {
                matrix[r][c] = 0;
            }
        }


    }

}
