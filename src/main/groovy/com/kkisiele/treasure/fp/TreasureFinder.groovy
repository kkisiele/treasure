package com.kkisiele.treasure.fp

import groovy.transform.CompileStatic

@CompileStatic
class TreasureFinder {
    private static final int NUMBER_OF_CELLS_PER_ROW = 5

    private final File file
    private final String startingClue

    TreasureFinder(File file, String clue) {
        this.file = file
        this.startingClue = clue
    }

    List<String> find() {
        List<String> cells = file
                .readLines()
                .collect { splitLine(it) }
                .flatten() as List<String>
        return find(cells, startingClue, [])
                .collect { formatCell(it) }
    }

    private String formatCell(String cell) {
        return cell.toList().join(" ")
    }

    List<String> find(List<String> cells, String clue, List<String> visitedCells) {
        if (clue in visitedCells) {
            return []
        }
        if (cells[indexOfClue(clue)] == clue) {
            return visitedCells + clue
        }
        return find(cells, cells[indexOfClue(clue)], visitedCells + clue)
    }

    static List<String> splitLine(String line) {
        return line.trim().tokenize()
    }

    static int indexOfClue(String clue) {
        return indexOfClue(clue.toInteger())
    }

    static int indexOfClue(Integer clue) {
        return indexOfClue((clue / 10) as int, (clue % 10) as int)
    }

    static int indexOfClue(Integer row, Integer column) {
        return ((row - 1) * NUMBER_OF_CELLS_PER_ROW) + column - 1
    }
}
