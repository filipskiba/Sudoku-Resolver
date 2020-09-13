package com.sudoku;



import com.sudoku.parts.Coordinates;
import com.sudoku.parts.SudokuBoard;
import com.sudoku.parts.SudokuElement;
import com.sudoku.validators.ValueValidators;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class SudokuSolver {

    private ValueValidators valueValidators = new ValueValidators();
    private ArrayDeque<BacktrackPoint> backtrackPoints = new ArrayDeque<>();
    private SudokuBoard resolvedBoard;
    public int backtrackMovesCounter = 0;

    public void resolve(SudokuBoard board) {
        ArrayList<SudokuElement> elements = board.getAllElements();
        for (SudokuElement element : elements) {
            if (element.getValue() == -1) {
                int col = element.getCoordinates().getColumn();
                int row = element.getCoordinates().getRow();
                if (!canPutElement(element, row, col, board)) {
                    element.fillPossibleValues();
                    if (canDoBacktrackMove()) {
                        backtrackMovesCounter++;
                        doBacktrackMove();
                    } else {
                        System.out.println("Can not resolve sudoku");
                    }
                    break;
                }
                this.resolvedBoard = board;
            }
        }
    }

    private boolean canPutElement(SudokuElement element, int row, int col, SudokuBoard board) {
        for (int i = 0; i < element.getPossibleValues().size(); i++) {

            int currentValue = element.getPossibleValues().get(i);
            if (valueValidators.isValueValid(row, col, currentValue, board)) {
                board.setElementValue(row, col, currentValue);

                try {
                    backtrackPoints.push(new BacktrackPoint(board.deepCopy(), new Coordinates(row, col), currentValue));
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            } else {

                board.getElement(row, col).deletePossibleValue(currentValue);
                i = i - 1; // Restart loop
            }

        }
        if (element.getValue() != -1)
            return true;
        else
            return false;
    }

    private boolean canDoBacktrackMove() {
        if (backtrackPoints.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void doBacktrackMove() {
        BacktrackPoint backtrackPoint = backtrackPoints.peek();
        Coordinates backtrackCoordinates = backtrackPoint.getCurrentPoint();
        int row = backtrackCoordinates.getRow();
        int col = backtrackCoordinates.getColumn();
        int backtrackValue = backtrackPoint.getCurrentValue();
        backtrackPoint.getBoard().getElement(row, col).deletePossibleValue(backtrackValue);
        backtrackPoint.getBoard().setElementValue(row, col, -1);
        SudokuBoard resultBoard = backtrackPoint.getBoard();
        backtrackPoints.peek().setBoard(resultBoard);
        backtrackPoints.pop();

        resolve(resultBoard);
    }

    public SudokuBoard getResolvedBoard() {
        return resolvedBoard;
    }
}
