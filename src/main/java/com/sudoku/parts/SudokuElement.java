package com.sudoku.parts;

import java.util.ArrayList;
import java.util.Objects;

public class SudokuElement {

    public static int EMPTY = -1;
    private int value = EMPTY;
    private Coordinates coordinates;
    private ArrayList<Integer> possibleValues = new ArrayList<>();

    public SudokuElement() {
        fillPossibleValues();
    }

    public SudokuElement(int value, Coordinates coordinates, ArrayList<Integer> possibleValues) {
        this.value = value;
        this.coordinates = coordinates;
        this.possibleValues = possibleValues;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void deletePossibleValue(int value) {
        this.possibleValues.removeIf(a -> a == value);
    }

    public ArrayList<Integer> getPossibleValues() {
        return this.possibleValues;
    }

    public void fillPossibleValues() {
        for (int i = 1; i < 10; i++) {
            this.possibleValues.add(i);
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        if (value == -1)
            return " |    | ";
        else
            return " | " + value + "  | ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuElement element = (SudokuElement) o;
        return value == element.value &&
                Objects.equals(coordinates, element.coordinates) &&
                Objects.equals(possibleValues, element.possibleValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, coordinates, possibleValues);
    }
}
