package com.kkisiele.treasure

import spock.lang.Specification

class ClueValidatorTest extends Specification {
    def "Should validate provided clue"() {
        when:
        def res = ClueValidator.isValid(clue)

        then:
        res == isValid

        where:
        clue  | isValid
        "11"  | true
        "21"  | true
        "55"  | true
        null  | false
        ""    | false
        "   " | false
        "01"  | false
        "10"  | false
        "20"  | false
        "26"  | false
        "56"  | false
        "111" | false
    }
}
