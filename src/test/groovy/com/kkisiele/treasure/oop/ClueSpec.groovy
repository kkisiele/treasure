package com.kkisiele.treasure.oop

import spock.lang.Specification

class ClueSpec extends Specification {
    def "Should return location corresponding to the clue"() {
        when:
        def location = new Clue(clue).toLocation()

        then:
        location == expectedLocation

        where:
        clue | expectedLocation
        "15" | new BoardLocation(1, 5)
        "55" | new BoardLocation(5, 5)
    }
}
