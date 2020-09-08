package com.sudoku;


import com.sudoku.parts.Coordinates;
import com.sudoku.parts.SudokuBoard;

public class BacktrackPoint {
    private SudokuBoard board;
    private Coordinates currentPoint;
    private int currentValue;

    public BacktrackPoint(SudokuBoard board, Coordinates currentPoint, int currentValue) {
        this.board = board;
        this.currentPoint = currentPoint;
        this.currentValue = currentValue;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public void setBoard(SudokuBoard board) {
        this.board = board;
    }

    public Coordinates getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Coordinates currentPoint) {
        this.currentPoint = currentPoint;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }


}
