package com.sudoku.controller;


import com.sudoku.SudokuSolver;
import com.sudoku.parts.SudokuBoard;
import com.sudoku.sample.SampleBoard;
import com.sudoku.validators.ValueValidators;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameController {

    private int row;
    private int col;
    private int value;
    private String data;
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private SudokuSolver sudokuSolver = new SudokuSolver();
    private SampleBoard sampleBoard = new SampleBoard();
    private ValueValidators valueValidator = new ValueValidators();
    private final String startMessage = "Witaj w programie do rozwiazywania sudoku. \n 1 - dodaj wartosc, 2 - rozwiaz sudoku, 3 - wyswietl tablice, 4 - wyswietl przykladowa tablice, 5 - rozwiaz przykladowa tablice, 6 - wyjscie";
    private final String resolvedMessage = "Sudoku rozwiazane w ";
    private final String cantResolve = "Nie mozna rozwiazac sudoku!";
    private final String putValue = "Wstaw wartosc do tablicy w formacie wiersz, kolumna, wartosc. Dla przykladu 234 wstawi w wierszu 2  kolumnie 3 wartosc 4";

    public void startGame() {
        System.out.println(startMessage);
        Scanner scan = new Scanner(System.in);
        int decision = scan.nextInt();

        switch (decision) {
            case 1:
                makeBoard();
                scan.close();
                break;
            case 2:
                long start = System.nanoTime();
                sudokuSolver.resolve(sudokuBoard);
                if (sudokuSolver.getResolvedBoard().getEmptyElementsCount() == 0) {
                    long end = System.nanoTime();
                    long elapsedTime = end - start;
                    double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
                    long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
                    System.out.println(resolvedMessage +elapsedTimeInSecond+" sek.");
                    sudokuBoard = sudokuSolver.getResolvedBoard();
                    System.out.println(sudokuBoard.printBoard());
                } else {
                    System.out.println(cantResolve);
                }
                sudokuBoard = new SudokuBoard();
                startGame();
                break;

            case 3:
                System.out.println(this.sudokuBoard.printBoard());
                startGame();
                break;

            case 4:
                System.out.println(sampleBoard.getSampleBoard().printBoard());
                startGame();
                break;
            case 5:
                sudokuSolver.resolve(sampleBoard.getSampleBoard());
                if (sudokuSolver.getResolvedBoard().getEmptyElementsCount() == 0) {
                    System.out.println(resolvedMessage);
                    sudokuBoard = sudokuSolver.getResolvedBoard();
                    System.out.println(sudokuBoard.printBoard());
                } else {
                    System.out.println(cantResolve);
                }
                sudokuBoard = new SudokuBoard();
                startGame();
                break;
            case 6:
                System.exit(1);
        }


        scan.close();
    }

    public void retrieveData() {
        char r = data.charAt(0);
        char c = data.charAt(1);
        char v = data.charAt(2);
        row = Character.getNumericValue(r);
        col = Character.getNumericValue(c);
        value = Character.getNumericValue(v);
    }

    public void makeBoard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(putValue);
        data = scanner.nextLine();

        if (inputValidator(data)) {
            retrieveData();

            if(valueValidator.isValueInRow(row-1,value,sudokuBoard)) {
                System.out.println("Wartosc "+ value +" wystepuje w wierszu "+ row+ ". Zmien wybrana liczbe.");
            }
            else if(valueValidator.isValueInColumn(col-1,value,sudokuBoard)){
                System.out.println("Wartosc "+ value +" występuje w kolumnie "+ col+ ". Zmien wybrana liczbe.");
            }
            else if(valueValidator.isValueInSection(row-1,col-1,value,sudokuBoard)){
                System.out.println("Wartosc "+ value +" występuje w sekcji. Zmien wybrana liczbe.");
            }
            else{
                sudokuBoard.setElementValue(row - 1, col - 1, value);
                System.out.println("Twoja wartosc w wierszu: " + row + " i kolumnie: " + col + " to: " + value);
            }

            System.out.println("Czy chcesz kontynuowac? T/N");
            String decision = scanner.nextLine().toUpperCase();
            switch (decision) {
                case "T":
                    makeBoard();
                    break;
                default:
                    startGame();
                    scanner.close();

            }
        } else {
            makeBoard();
        }
    }

    private boolean inputValidator(String data) {
        if (data.length() != 3) {
            System.out.println("Nieprawidlowy format");
            return false;
        } else if (Character.getNumericValue(data.charAt(0)) < 1 || Character.getNumericValue(data.charAt(1)) < 1 || Character.getNumericValue(data.charAt(2)) < 1) {
            System.out.println("Wybierz wartosc wieksza od 0");
            return false;
        }
        return true;
    }
}
