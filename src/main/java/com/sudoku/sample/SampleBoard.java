package com.sudoku.sample;


import com.sudoku.parts.SudokuBoard;

public class SampleBoard {

    public SudokuBoard getSampleBoard() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setElementValue(0, 1, 2);
        sudokuBoard.setElementValue(0, 3, 5);
        sudokuBoard.setElementValue(0, 5, 1);
        sudokuBoard.setElementValue(0, 7, 9);

        sudokuBoard.setElementValue(1, 0, 8);
        sudokuBoard.setElementValue(1, 3, 2);
        sudokuBoard.setElementValue(1, 5, 3);
        sudokuBoard.setElementValue(1, 8, 6);

        sudokuBoard.setElementValue(2, 1, 3);
        sudokuBoard.setElementValue(2, 4, 6);
        sudokuBoard.setElementValue(2, 7, 7);


        sudokuBoard.setElementValue(3, 2, 1);
        sudokuBoard.setElementValue(3, 6, 6);


        sudokuBoard.setElementValue(4, 0, 5);
        sudokuBoard.setElementValue(4, 1, 4);
        sudokuBoard.setElementValue(4, 7, 1);
        sudokuBoard.setElementValue(4, 8, 9);


        sudokuBoard.setElementValue(5, 2, 2);
        sudokuBoard.setElementValue(5, 6, 7);


        sudokuBoard.setElementValue(6, 1, 9);
        sudokuBoard.setElementValue(6, 4, 3);
        sudokuBoard.setElementValue(6, 7, 8);


        sudokuBoard.setElementValue(7, 0, 2);
        sudokuBoard.setElementValue(7, 3, 8);
        sudokuBoard.setElementValue(7, 5, 4);
        sudokuBoard.setElementValue(7, 8, 7);

        sudokuBoard.setElementValue(8, 1, 1);
        sudokuBoard.setElementValue(8, 3, 9);
        sudokuBoard.setElementValue(8, 5, 7);
        sudokuBoard.setElementValue(8, 7, 6);
        return sudokuBoard;
    }
}
