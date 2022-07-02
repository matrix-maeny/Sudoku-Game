package com.matrix_maeny.sudokugame.matrices;

public class Matrix12x12 {

    private int[][] matrix12x12;

    private int selectedRow;
    private int selectedColumn;

    public Matrix12x12() {
        selectedColumn = -1;
        selectedRow = -1;

        matrix12x12 = new int[12][12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matrix12x12[i][j] = 0;
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
        matrix12x12[r][c] = number;
    }

    public int getNumber(int r, int c) {
        return matrix12x12[r][c];
    }

    public void resetBoard(){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matrix12x12[i][j] = 0;
            }
        }
    }
}
