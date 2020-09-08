package com.sudoku.validators;


import com.sudoku.parts.Coordinates;
import com.sudoku.parts.Sections;
import com.sudoku.parts.SudokuBoard;
import com.sudoku.parts.SudokuElement;

import java.util.ArrayList;

public class ValueValidators {
    private Sections sections = new Sections();

    public boolean isValueInSection(int row, int col, int value, SudokuBoard sudokuBoard) {
        int sectionNumber = sections.getSectionNumberByCoordinates(new Coordinates(row, col));
        ArrayList<Coordinates> list = sections.getCoordinatesBySection(sectionNumber);

        for (Coordinates coordinates : list) {
            SudokuElement elementToCompare = sudokuBoard.getElement(coordinates.getRow(), coordinates.getColumn());
            if (elementToCompare.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isValueInColumn(int col, int value, SudokuBoard sudokuBoard) {
        ArrayList<SudokuElement> elements = sudokuBoard.getElementsInColumn(col);
        for (SudokuElement element : elements) {
            if (element.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isValueInRow(int row, int value, SudokuBoard sudokuBoard) {
        ArrayList<SudokuElement> elements = sudokuBoard.getElementsInRow(row);
        for (SudokuElement element : elements) {
            if (element.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isValueValid(int row, int col, int currentValue, SudokuBoard board) {
        if (!isValueInSection(row, col, currentValue, board) && !isValueInColumn(col, currentValue, board) && !isValueInRow(row, currentValue, board)) {
            return true;
        } else {
            return false;
        }
    }


}
