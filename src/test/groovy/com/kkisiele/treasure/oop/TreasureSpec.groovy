package com.kkisiele.treasure.oop

import com.kkisiele.treasure.TestFile
import spock.lang.Specification

class TreasureSpec extends Specification {
    def "Should find treasure along with the visited locations"() {
        given:
        def treasure = new Treasure(new TextFileBoardRepository(TestFile.get()))

        when:
        def result = treasure.hunt(new Clue("11"))

        then:
        result == [
                new BoardLocation(1, 1),
                new BoardLocation(5, 5),
                new BoardLocation(1, 5),
                new BoardLocation(2, 1),
                new BoardLocation(4, 4),
                new BoardLocation(3, 2),
                new BoardLocation(1, 3),
                new BoardLocation(2, 5),
                new BoardLocation(4, 3)
        ]
    }

    def "Should not find any treasure"() {
        given:
        def treasure = new Treasure(new TextFileBoardRepository(TestFile.get()))

        when:
        def result = treasure.hunt(new Clue("41"))

        then:
        result == []
    }
}
