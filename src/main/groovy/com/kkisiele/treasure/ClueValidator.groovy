package com.kkisiele.treasure

import groovy.transform.CompileStatic

@CompileStatic
class ClueValidator {
    static void validate(String clue) {
        if (!isValid(clue)) {
            throw new ValidatorException("Invalid clue [$clue] provided")
        }
    }

    static boolean isValid(String clue) {
        if (clue == null || clue.isBlank()) {
            return false
        }

        try {
            int row = (clue.toInteger() / 10) as int
            int column = (clue.toInteger() % 10) as int
            return row in 1..5 && column in 1..5
        } catch (NumberFormatException ex) {
            return false
        }
    }
}
