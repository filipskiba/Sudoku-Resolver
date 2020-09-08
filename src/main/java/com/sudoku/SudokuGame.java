package com.sudoku;

import com.sudoku.controller.GameController;

public class SudokuGame {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
