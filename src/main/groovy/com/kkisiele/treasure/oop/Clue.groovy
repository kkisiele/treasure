package com.kkisiele.treasure.oop

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
final class Clue {
    final int value

    Clue(String value) {
        this(value as int)
    }

    Clue(int value) {
        if (value < 11) {
            throw new IllegalArgumentException("Invalid clue value [$value]")
        }
        this.value = value
    }

    BoardLocation toLocation() {
        return new BoardLocation((value / 10) as int, (value % 10) as int)
    }

    @Override
    String toString() {
        return value;
    }
}
