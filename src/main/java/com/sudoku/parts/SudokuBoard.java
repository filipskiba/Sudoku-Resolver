package com.sudoku.parts;

import com.sudoku.Prototype;

import java.util.ArrayList;
import java.util.Objects;


public class SudokuBoard extends Prototype {

    private ArrayList<SudokuRow> board = new ArrayList<>();
    private Sections sections = new Sections();
    private StringBuilder stringBuilder = new StringBuilder();

    public ArrayList<SudokuRow> getBoard() {
        return board;
    }

    public void makeNewBoard() {
        for (int i = 0; i < 9; i++) {
            this.board.add(new SudokuRow());
        }
        for (SudokuRow sudokuRow : board) {
            sudokuRow.makeNewRow();
        }
    }


    public SudokuBoard() {
        makeNewBoard();
        initializeCoordinates();
    }

    public String printBoard() {
        String drawedBoard = "";
        String line = " ------  ------  ------  ------  ------  ------  ------  ------  ------";
        for (SudokuRow r : this.board) {
            drawedBoard += line + "\n" + r.drawRow() + "\n";
            //         System.out.println(r.drawRow());
        }
        drawedBoard += line;
        return drawedBoard;
        //    System.out.println(drawedBoard);
    }

    public void setElementValue(int row, int col, int value) {
        this.board.get(row).getRowElement(col).setValue(value);

    }

    public SudokuElement getElement(int row, int col) {
        return board.get(row).getRowElement(col);
    }


    public void initializeCoordinates() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                this.board.get(row).getRowElement(column).setCoordinates(new Coordinates(row, column));
            }
        }
    }

    public ArrayList<SudokuElement> getAllElements() {
        ArrayList<SudokuElement> resultList = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuElement sudokuElement = this.board.get(row).getRowElement(col);
                resultList.add(sudokuElement);
            }
        }
        return resultList;
    }

    public ArrayList<SudokuElement> getElementsInColumn(int col) {
        ArrayList<SudokuElement> resultList = new ArrayList<>();
        for (SudokuRow row : board) {
            resultList.add(row.getRowElement(col));
        }
        return resultList;
    }

    public ArrayList<SudokuElement> getElementsInRow(int row) {
        ArrayList<SudokuElement> resultList = new ArrayList<>();
        for (int col = 0; col < 9; col++) {
            resultList.add(this.board.get(row).getRowElement(col));
        }
        return resultList;
    }

    public long getEmptyElementsCount() {
        return getAllElements().stream().filter(e -> e.getValue() == -1).count();

    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow rowList : board) {
            SudokuRow clonedRowList = new SudokuRow();
            for (SudokuElement element : rowList.getRow()) {
                clonedRowList.getRow().add(new SudokuElement(element.getValue(), element.getCoordinates(), element.getPossibleValues()));
            }

            clonedBoard.getBoard().add(clonedRowList);
        }
        return clonedBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equals(board, that.board) &&
                Objects.equals(sections, that.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, sections);
    }
}
