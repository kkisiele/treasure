package com.kkisiele.treasure.fp

import com.kkisiele.treasure.TestFile
import spock.lang.Specification

class TreasureFinderSpec extends Specification {
    def "Should convert given clue to array's index"() {
        when:
        int actualIndex = TreasureFinder.indexOfClue(clue)

        then:
        actualIndex == expectedIndex

        where:
        clue | expectedIndex
        "11" | 0
        "12" | 1
        "21" | 5
        "55" | 24
    }

    def "Should return the visited cells for the found treasure"() {
        given:
        def finder = new TreasureFinder(TestFile.get(), startingClue)

        when:
        def visitedCells = finder.find()

        then:
        visitedCells == result

        where:
        startingClue | result
        "11"         | ["1 1", "5 5", "1 5", "2 1", "4 4", "3 2", "1 3", "2 5", "4 3"]
        "41"         | []
    }
}
