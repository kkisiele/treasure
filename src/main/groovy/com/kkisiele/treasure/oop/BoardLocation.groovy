package com.kkisiele.treasure.oop

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
final class BoardLocation {
    final int row
    final int column

    BoardLocation(int row, int column) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException("Invalid row [$row] or column [$column] value")
        }
        this.row = row
        this.column = column
    }

    @Override
    String toString() {
        return row + " " + column;
    }
}
