package com.kkisiele.treasure.oop

import groovy.transform.PackageScope

@PackageScope
class TextFileBoardRepository implements BoardRepository {
    private final File file

    TextFileBoardRepository(File file) {
        this.file = file
    }

    @Override
    Board get() {
        return new Board(parsedFile())
    }

    private Map<BoardLocation, Clue> parsedFile() {
        Map<BoardLocation, Clue> clues = new HashMap<>()
        file.eachLine(0, { String line, Integer lineIndex ->
            clues.putAll(parsedLine(line, lineIndex))
        })
        return clues
    }

    private Map<BoardLocation, Clue> parsedLine(String line, Integer lineIndex) {
        Map<BoardLocation, Clue> clues = new HashMap<>()
        line.split().eachWithIndex({ String item, Integer itemIndex ->
            clues.put(new BoardLocation(lineIndex + 1, itemIndex + 1), new Clue(item))
        })
        return clues
    }
}
