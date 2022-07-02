package com.matrix_maeny.sudokugame.matrices;


public class Matrix9x9 {

    private int[][] matrix9x9;

    private int selectedRow;
    private int selectedColumn;

    public Matrix9x9() {
        selectedColumn = -1;
        selectedRow = -1;
        matrix9x9 = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix9x9[i][j] = 0;
            }
        }
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public int getSelectedColumn() {
        return selectedColumn;
    }

    public void setSelectedColumn(int selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    public void setNumber(int number, int r, int c) {
        matrix9x9[r][c] = number;
    }

    public int getNumber(int r, int c) {
        return matrix9x9[r][c];
    }

    public void resetBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix9x9[i][j] = 0;
            }
        }
    }
}
