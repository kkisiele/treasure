package com.kkisiele.treasure.oop

import com.kkisiele.treasure.TestFile
import spock.lang.Specification

class TextFileBoardRepositorySpec extends Specification {
    def "Should return clue at the given location"() {
        given:
        def repository = new TextFileBoardRepository(TestFile.get())
        def board = repository.get()

        when:
        def actualClue = board.clue(location)

        then:
        actualClue == expectedClue

        where:
        location                | expectedClue
        new BoardLocation(1, 1) | new Clue(55)
        new BoardLocation(2, 3) | new Clue(11)
        new BoardLocation(5, 5) | new Clue(15)
    }

    def "Should return the total number of clues"() {
        given:
        def repository = new TextFileBoardRepository(TestFile.get())
        def board = repository.get()

        when:
        def clues = board.numberOfClues()

        then:
        clues == 25
    }
}
