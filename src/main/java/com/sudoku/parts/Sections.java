package com.sudoku.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sections {

    private HashMap<Coordinates, Integer> sectionMap = new HashMap<>();

    public Sections() {
        addSectionCoordinates(0, 3, 0, 3, 1);
        addSectionCoordinates(0, 3, 3, 6, 2);
        addSectionCoordinates(0, 3, 6, 9, 3);

        addSectionCoordinates(3, 6, 0, 3, 4);
        addSectionCoordinates(3, 6, 3, 6, 5);
        addSectionCoordinates(3, 6, 6, 9, 6);


        addSectionCoordinates(6, 9, 0, 3, 7);
        addSectionCoordinates(6, 9, 3, 6, 8);
        addSectionCoordinates(6, 9, 6, 9, 9);
    }

    private void addSectionCoordinates(int rowStart, int rowEnd, int colStart, int colEnd, int section) {
        for (int r = rowStart; r < rowEnd; r++) {
            for (int c = colStart; c < colEnd; c++) {
                sectionMap.put(new Coordinates(r, c), section);
            }
        }
    }

    public ArrayList<Coordinates> getCoordinatesBySection(int section) {
        ArrayList<Coordinates> sectionCoordinates = new ArrayList<>();
        for (Map.Entry<Coordinates, Integer> entry : sectionMap.entrySet()) {
            if (entry.getValue() == section) {
                sectionCoordinates.add(entry.getKey());
            }
        }
        return sectionCoordinates;
    }

    public int getSectionNumberByCoordinates(Coordinates coordinates) {
        return sectionMap.get(coordinates);
    }

}
