package com.sudoku.parts;

import java.util.ArrayList;
import java.util.Objects;

public class SudokuRow {
    private ArrayList<SudokuElement> row = new ArrayList<>();

    public SudokuRow() {
        //  makeNewRow();
    }

    public void makeNewRow() {
        for (int i = 0; i < 9; i++) {
            row.add(new SudokuElement());
        }
    }

    public ArrayList<SudokuElement> getRow() {
        return row;
    }

    public SudokuElement getRowElement(int col) {
        return row.get(col);
    }

    public String drawRow() {
        String drawedRow = "";
        for (SudokuElement sudokuElement : row) {
            drawedRow += sudokuElement;
        }
        return drawedRow;
    }

    @Override
    public String toString() {
        return row.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuRow sudokuRow = (SudokuRow) o;
        return Objects.equals(row, sudokuRow.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row);
    }
}
