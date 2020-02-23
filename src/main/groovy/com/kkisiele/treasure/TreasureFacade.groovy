package com.kkisiele.treasure

import com.kkisiele.treasure.fp.TreasureFinder
import com.kkisiele.treasure.oop.Clue
import com.kkisiele.treasure.oop.Treasure

import javax.inject.Singleton

@Singleton
class TreasureFacade {
    private final File file = new File(getClass().getResource("/sample_input.txt").file)

    List<String> findTreasure(String clue) {
        ClueValidator.validate(clue)
        return findTreasureBothWays(clue)
    }

    private List<String> findTreasureBothWays(String clue) {
        List<String> functionResult = findTreasureInFunctionalWay(clue)
        List<String> objectOrientedResult = findTreasureInObjectOrientedWay(clue)
        if (functionResult != objectOrientedResult) {
            throw new RuntimeException("Different results returned. Functional result [$functionResult], object-oriented result [$objectOrientedResult]")
        }
        return functionResult
    }

    private List<String> findTreasureInFunctionalWay(String clue) {
        def finder = new TreasureFinder(file, clue)
        return finder.find()
    }

    private List<String> findTreasureInObjectOrientedWay(String clue) {
        def treasure = new Treasure(file)
        return treasure.hunt(new Clue(clue))
                .collect { it.toString() }
    }
}
