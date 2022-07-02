package com.matrix_maeny.sudokugame.matrices;

public class Matrix15x15 {


    private int[][] matrix15x15;

    private int selectedRow;
    private int selectedColumn;

    public Matrix15x15(){
        selectedColumn  =-1;
        selectedRow  =-1;
        matrix15x15 = new int[15][15];

        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                matrix15x15[i][j] = 0;
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

    public void setNumber(int number,int r,int c){
        matrix15x15[r][c] = number;
    }

    public int getNumber(int r,int c){
        return matrix15x15[r][c];
    }

    public void resetBoard(){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                matrix15x15[i][j] = 0;
            }
        }
    }
}
