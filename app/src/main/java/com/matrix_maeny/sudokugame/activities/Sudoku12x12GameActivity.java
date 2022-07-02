package com.matrix_maeny.sudokugame.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.matrix_maeny.sudokugame.R;
import com.matrix_maeny.sudokugame.checkers.MatrixChecker1;
import com.matrix_maeny.sudokugame.checkers.MatrixChecker2;
import com.matrix_maeny.sudokugame.checkers.MatrixChecker3;
import com.matrix_maeny.sudokugame.databases.LevelsDataBase;
import com.matrix_maeny.sudokugame.databases.SoundDataBase;
import com.matrix_maeny.sudokugame.matrices.Matrix12x12;
import com.matrix_maeny.sudokugame.matrices.Matrix9x9;
import com.matrix_maeny.sudokugame.solvers.Solver1;
import com.matrix_maeny.sudokugame.solvers.Solver2;
import com.matrix_maeny.sudokugame.sudokuboards.SudokuBoard1;
import com.matrix_maeny.sudokugame.sudokuboards.SudokuBoard2;

import java.util.Objects;
import java.util.Random;

public class Sudoku12x12GameActivity extends AppCompatActivity {

    private int levelNumber = -1;

    private SudokuBoard2 gameBoard;
    private Solver2 solver;
    private MatrixChecker2 checker;
    private AppCompatButton checkBtn;

    private boolean pressed = false;
    private Thread thread = null;
    private final Handler handler = new Handler();
    private MediaPlayer player = null;
    private LevelsDataBase levelsDataBase = null;

    boolean soundsEnabled = true;
    boolean winStatus = true;

    private final int totalBoxes = 144;
    private final Matrix12x12 matrix12x12 = new Matrix12x12();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku12x12_game);
        Objects.requireNonNull(getSupportActionBar()).hide();


        levelNumber = getIntent().getIntExtra("levelNumber", -1);

        gameBoard = findViewById(R.id.sudokuBoard2);
        checkBtn = findViewById(R.id.check_btn_12x12);

        solver = gameBoard.getSolver();
        checker = new MatrixChecker2(Sudoku12x12GameActivity.this);

        setTheSounds();

        startSettingBoxValues();
        invalidate();
    }

    MediaPlayer.OnCompletionListener playerListener = MediaPlayer::release;

    private void startSettingBoxValues() {
        SetTheBoardNumbers setTheBoardNumbers = new SetTheBoardNumbers();
        thread = new Thread(setTheBoardNumbers);
        thread.start();
        tempToast("Generating Sudoku...", 1);
        playGeneratingSound();
    }

    private void setTheSounds() {
        SoundDataBase soundDataBase = new SoundDataBase(Sudoku12x12GameActivity.this);
        Cursor cursor = soundDataBase.getData();

        if (cursor.getCount() != 0) {
            cursor.moveToNext();
            String state = cursor.getString(1);

            if (state.equals("disabled")) {
                soundsEnabled = false;
            } else {
                soundsEnabled = true;
            }
        } else {
            soundsEnabled = true;
        }
    }

    private void invalidate() {
        gameBoard.invalidate();
    }

    private void tempToast(String m, int time) {
        if (time == 0) {
            Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, m, Toast.LENGTH_LONG).show();

        }

    }

    private boolean setTheValues(int number) {
        pressed = false;


        checker.setNumberPos(number, matrix12x12.getSelectedRow(), matrix12x12.getSelectedColumn());

        if (checker.check(matrix12x12.getSelectedRow(), matrix12x12.getSelectedColumn())) {

            return true;
        } else {
            checker.setNumberPos(0, matrix12x12.getSelectedRow(), matrix12x12.getSelectedColumn());
            return false;
        }
    }


    private void setTheValues2(int number) {
        if(winStatus){
            tempToast("Game over..! Go to next Level..",1);
            return;
        }
        if (thread != null && thread.isAlive()) {
            tempToast("Please wait while generating Sudoku... Or restart the game", 1);

            return;
        }
        if (solver.getSelectedRow() == -1) {
            tempToast("Please select a certain Box", 0);
            return;
        }
        if (matrix12x12.getNumber(solver.getSelectedRow() - 1, solver.getSelectedColumn() - 1) != 0) {
            tempToast("Can't change filled value", 0);
            return;
        }

        if (soundsEnabled) {
            playButtonSound();
        }

        solver.setNumberPos(number);
        checker.setNumberPos(number, solver.getSelectedRow(), solver.getSelectedColumn());
        invalidate();

    }


    private int selectRandomNumber() {
        Random random = new Random();
        int randomNumber = -1;

        switch (levelNumber) {
            case 0:
                randomNumber = 100 + random.nextInt(5);
                break;
            case 1:
                randomNumber = 100 + random.nextInt(4);
                break;
            case 2:
                randomNumber = 100 + random.nextInt(14);
                break;
            case 3:
                randomNumber = 100 + random.nextInt(3);
                break;
            case 4:
                randomNumber = 100 + random.nextInt(15);
                break;
            case 5:
                randomNumber = 100 + random.nextInt(13);
                break;
            case 6:
                randomNumber = 100 + random.nextInt(2);
                break;
            case 7:
                randomNumber = 100 + random.nextInt(20);
                break;
            case 8:
                randomNumber = 100 + random.nextInt(7);
                break;
            case 9:
                randomNumber = 110 + random.nextInt(6);
                break;

            case 10:
                randomNumber = 100 + random.nextInt(19);
                break;
            case 11:
                randomNumber = 100 + random.nextInt(22);
                break;
            case 12:
                randomNumber = 100 + random.nextInt(18);
                break;
            case 13:
                randomNumber = 100 + random.nextInt(12);
                break;
            case 14:
                randomNumber = 100 + random.nextInt(11);
                break;
            case 15:
                randomNumber = 100 + random.nextInt(8);
                break;
            case 16:
                randomNumber = 100 + random.nextInt(10);
                break;
            case 17:
                randomNumber = 100 + random.nextInt(21);
                break;
            case 18:
                randomNumber = 100 + random.nextInt(16);
                break;
            case 19:
                randomNumber = 100 + random.nextInt(23);
                break;
        }
        return randomNumber;
    }

    private boolean setTheBoard() {

        Random random = new Random();
        int randomNumber, randomRow   /* a row for number frequency*/;
        int row, column;
        randomNumber = selectRandomNumber();
        int fillingBoxes = totalBoxes - randomNumber;
        int[][] tempRowColumnMatrix = new int[12][12];
        int[] numberFrequency = new int[12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                tempRowColumnMatrix[i][j] = 0;
            }
            numberFrequency[i] = 0;
        } // initialization of matrices


        for (int i = 0; i <= fillingBoxes; i++) {

            boolean flag; // to exit at a certain stage
            abc:
            // tag for exit
            do {
                do {
                    row = random.nextInt(12); // generating a random box
                    column = random.nextInt(12);
                } while (tempRowColumnMatrix[row][column] != 0); // creating a box which isn't filled

                tempRowColumnMatrix[row][column] = 1; // setting the frequency in which it should not occur for the next time
                matrix12x12.setSelectedColumn(column + 1); // setting into the board
                matrix12x12.setSelectedRow(row + 1); // setting into the board

                do {
                    flag = false;
                    randomRow = random.nextInt(9);

                    numberFrequency[randomRow] = 1;
                    randomNumber = randomRow + 1;

                    if (setTheValues(randomNumber)) { // if number is seated.. break the whole loop
                        matrix12x12.setNumber(randomNumber, row, column);
                        solver.gameBoard[row][column] = randomNumber;
                        if (solver.resetEmptyBoxes()) {
                            if (solver.setEmptyBoxIndexes())
                                break abc;
                        }
                    }

                    for (int x = 0; x < 12; x++) {
                        if (numberFrequency[x] == 0) {
                            flag = true;
                            break;
                        }
                    }


                } while (flag); // creating a random number and to fill in the board

                for (int x = 0; x < 12; x++) {
                    numberFrequency[x] = 0;
                } // making the row frequency to null.. to initialize again..

            } while (true);

//            for(int number = 1;number <10;number++){
//                if(setTheValues(number)){
//                    break abc;
//                }
//            }

        }

        if (solver.resetEmptyBoxes())
            solver.setEmptyBoxIndexes();

        return true;
    }


    public void Btn21(View view) {
        setTheValues2(1);
    }

    public void Btn22(View view) {
        setTheValues2(2);
    }

    public void Btn23(View view) {
        setTheValues2(3);
    }

    public void Btn24(View view) {
        setTheValues2(4);
    }

    public void Btn25(View view) {
        setTheValues2(5);
    }

    public void Btn26(View view) {
        setTheValues2(6);
    }

    public void Btn27(View view) {
        setTheValues2(7);
    }

    public void Btn28(View view) {
        setTheValues2(8);
    }

    public void Btn29(View view) {
        setTheValues2(9);
    }

    public void Btn210(View view) {
        setTheValues2(10);
    }

    public void Btn211(View view) {
        setTheValues2(11);
    }

    public void Btn212(View view) {
        setTheValues2(12);
    }

    public void BtnX2(View view) {
        if(winStatus){
            tempToast("Game over..! Go to next Level..",1);
            return;
        }
        if (thread != null && thread.isAlive()) {
            tempToast("Please wait while generating Sudoku... Or restart the game", 1);

            return;
        }

        if (solver.getSelectedRow() != -1) {
            if (matrix12x12.getNumber(solver.getSelectedRow() - 1, solver.getSelectedColumn() - 1) == 0) {
                if (soundsEnabled) {
                    playXSound();
                }
                solver.setNumberPos(0);
                checker.setNumberPos(0, solver.getSelectedRow(), solver.getSelectedColumn());

                invalidate();
            } else {
                tempToast("Can't clear filled value", 0);
            }
        } else {
            tempToast("Please select a box", 0);
        }
    }

    public void BtnCheck2(View view) {

        if(winStatus){
            tempToast("Game over..! Go to next Level..",1);
            return;
        }
        if (thread != null && thread.isAlive()) {
            tempToast("Please wait while generating Sudoku... Or restart the game", 1);

            return;
        }

        int n = checker.checkSudokuStatus();

        if (n == 1) {
            winStatus = true;

            tempToast("Congratulations..! You Won ", 1);
            if (soundsEnabled) {
                playWinSound();
            }
            updateLevels();
            handler.postDelayed(() -> tempToast("You can go to Next Level", 1), 2000);
        }

        if (n == 2) {
            tempToast("Some of the boxes are unfilled", 1);
        }

        if (n == 0) {
            tempToast("Incorrect values.. Try again", 1);
        }

    }


    private void updateLevels() {
        levelsDataBase = new LevelsDataBase(Sudoku12x12GameActivity.this);


        if ((levelNumber + 2) == 21) {
            if (!levelsDataBase.updateData(getString(R.string.sudoku12x12), 1, 0)) {
                tempToast("Some error occurred in saving level: contact matrix", 1);
                return;
            }
            for (int i = 2; i <= 20; i++) {
                if (!levelsDataBase.updateData(getString(R.string.sudoku12x12), i, 0)) {
                    tempToast("Some error occurred in saving level: contact matrix", 1);
                    break;
                }
            }
            return;
        }

        Cursor cursor = levelsDataBase.getData();

        if (cursor.getCount() != 0) {
            cursor.moveToNext();
            cursor.moveToNext();


            if (!levelsDataBase.updateData(getString(R.string.sudoku12x12), levelNumber + 2, 1)) {
                tempToast("Some error occurred in saving level: contact matrix", 1);
            }
        }
        levelsDataBase.close();
    }


    //sounds session

    private void playXSound() {
        stopSound();

        player = MediaPlayer.create(Sudoku12x12GameActivity.this, R.raw.click_sound3);
        player.setOnCompletionListener(playerListener);
        player.setLooping(false);
        player.start();
    }

    private void playButtonSound() {
        stopSound();

        player = MediaPlayer.create(Sudoku12x12GameActivity.this, R.raw.click_sound2);
        player.setOnCompletionListener(playerListener);
        player.setLooping(false);
        player.start();
    }

    private void playWinSound() {
        stopSound();

        player = MediaPlayer.create(Sudoku12x12GameActivity.this, R.raw.winning_sound);
        player.setOnCompletionListener(playerListener);
        player.setLooping(false);
        player.start();
    }

    private void stopSound() {
        if (player != null) {
            try {
                player.stop();
            } catch (Exception ignored) {
            } finally {
                player.release();
            }

        }
    }

    private void playGeneratingSound() {
        stopSound();

        player = MediaPlayer.create(Sudoku12x12GameActivity.this, R.raw.generating_sound);
        player.setLooping(false);
        player.setOnCompletionListener(playerListener);
        player.start();
    }

    public class SetTheBoardNumbers implements Runnable {

        @Override
        public void run() {
            if (setTheBoard()) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tempToast("You can start Game", 1);
                    }
                });
                stopSound();

            }
        }
    }

    @Override
    public void onBackPressed() {
        stopSound();
        if (thread != null && thread.isAlive()) {
            try {
                thread.stop();
                thread = null;
            } catch (Exception ignored) {
            }
        }
        super.onBackPressed();
    }
}