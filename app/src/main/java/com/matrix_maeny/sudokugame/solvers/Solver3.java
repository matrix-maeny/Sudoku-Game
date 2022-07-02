package com.matrix_maeny.sudokugame.solvers;


import java.util.ArrayList;

public class Solver3 {

    public int[][] gameBoard;          // this consists of the total sudoku solved data
    public int[][] gameBoardMatrix;          // this consists of the total sudoku solved data
    ArrayList<ArrayList<Object>> emptyBox;      // contains empty box indexes after solving

    int selectedRow;            // holds the selected row and columns
    int selectedColumn;
    int selectedMatrixRow;
    int selectedMatrixColumn;

    public Solver3() {
        selectedColumn = -1;        // initially setting them to -1
        selectedRow = -1;
        selectedMatrixRow = -1; // this is for whole matrix
        selectedMatrixColumn = -1; // this too

        gameBoard = new int[15][15];  // allocating array of 9/9
        gameBoardMatrix = new int[15][15];  // allocating array of 9/9

        for (int r = 0; r < 15; r++) {           // setting them to zero.. off-course it allocates but for safety..
            for (int c = 0; c < 15; c++) {
                gameBoard[r][c] = 0;
                gameBoardMatrix[r][c] = 0;

            }
        }

        emptyBox = new ArrayList<>(); // creating empty list
    }

    public int getSelectedMatrixRow() {
        return selectedMatrixRow;
    }

    public void setSelectedMatrixRow(int selectedMatrixRow) {
        this.selectedMatrixRow = selectedMatrixRow;
    }

    public int getSelectedMatrixColumn() {
        return selectedMatrixColumn;
    }

    public void setSelectedMatrixColumn(int selectedMatrixColumn) {
        this.selectedMatrixColumn = selectedMatrixColumn;
    }

    public int getSelectedRow() { // for setting the row
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) { // this is for setting the row
        this.selectedRow = selectedRow;
    }

    public int getSelectedColumn() { // for getting the column
        return selectedColumn;
    }

    public void setSelectedColumn(int selectedColumn) { // for setting teh column
        this.selectedColumn = selectedColumn;
    }

     public boolean setEmptyBoxIndexes() {
         try {
             Thread.sleep(30);
         } catch (Exception ignored) {
         }
        for (int r = 0; r < 15; r++) {
            for (int c = 0; c < 15; c++) {
                if (gameBoard[r][c] == 0) {
                    emptyBox.add(new ArrayList<>());
                    emptyBox.get(emptyBox.size() - 1).add(r); // adding that particular row and column
                    emptyBox.get(emptyBox.size() - 1).add(c);
                }
            }
        }
        return true;
    }

    public void setNumberPos(int num) {
        if (selectedRow != -1 && selectedColumn != -1) {
            if (gameBoard[selectedRow - 1][selectedColumn - 1] == num) { // when you double click the button, the button gonna empty the box
                gameBoard[selectedRow - 1][selectedColumn - 1] = 0;
                gameBoardMatrix[selectedRow - 1][selectedColumn - 1] = 0;
            } else {
                gameBoard[selectedRow - 1][selectedColumn - 1] = num; // or else if it is the single click... then set the number
                gameBoardMatrix[selectedRow - 1][selectedColumn - 1] = num; // or else if it is the single click... then set the number
            }
        }
    }

    public int[][] getGameBoard() { // for getting the gameBoard. consists of solved data
        return gameBoard;
    }

     public ArrayList<ArrayList<Object>> getEmptyBoxIndexes() { // for getting emptyBox indexes
         try {
             Thread.sleep(30);
         } catch (Exception ignored) {
         }
        return emptyBox;
    }

    private boolean check(int row, int col) {

        if (this.gameBoard[row][col] > 0) {

            for (int i = 0; i < 15; i++) {
                if (this.gameBoard[i][col] == this.gameBoard[row][col] && row != i) {
                    return false;
                }

                if (this.gameBoard[row][i] == this.gameBoard[row][col] && col != i) {
                    return false;
                }
            }

            int boxRow = row / 3;
            int boxCol = col / 5;

            for (int r = boxRow * 3; r < (boxRow * 3) + 3; r++) {
                for (int c = boxCol * 5; c < (boxCol * 5) + 5; c++) {

                    if (this.gameBoard[r][c] == this.gameBoard[row][col] && row != r && col != c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public boolean solve3() {
        int row = -1, col = -1;

        for (int r = 0; r < 15; r++) {
            for (int c = 0; c < 15; c++) {
                if (this.gameBoard[r][c] == 0) {
                    row = r;
                    col = c;
                    break;
                }
            }
        }

        if (row == -1) return true;

        for (int i = 1; i <= 15; i++) {
            this.gameBoard[row][col] = i;


            if (check(row, col)) {
                if (solve3()) {
                    return true;
                }
            }
            this.gameBoard[row][col] = 0;

        }

        return false;
    }

    public boolean solveMatrix3() {
        int row = -1, col = -1;

        for (int r = 0; r < 15; r++) {
            for (int c = 0; c < 15; c++) {
                if (this.gameBoardMatrix[r][c] == 0) {
                    row = r;
                    col = c;
                    break;
                }
            }
        }

        if (row == -1) return true;

        for (int i = 1; i <= 15; i++) {
            this.gameBoardMatrix[row][col] = i;


            if (check(row, col)) {
                if (solveMatrix3()) {
                    return true;
                }
            }
            this.gameBoardMatrix[row][col] = 0;

        }

        return false;
    }

    public void resetBoard() {
        for (int r = 0; r < 15; r++) {
            for (int c = 0; c < 15; c++) {
                gameBoard[r][c] = 0;
            }
        }

        resetEmptyBoxes();
    }

    public boolean resetEmptyBoxes() {
        emptyBox = new ArrayList<>();
        return true;
    }

}

