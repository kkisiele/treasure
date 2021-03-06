package com.kkisiele.treasure.oop

import groovy.transform.CompileStatic
import groovy.transform.PackageScope

@PackageScope
@CompileStatic
class Board {
    private final Map<BoardLocation, Clue> clues
    private final List<BoardLocation> visitedLocations = new ArrayList<>()
    private BoardLocation currentLocation

    Board(Map<BoardLocation, Clue> clues) {
        this.clues = new HashMap<>(clues)
    }

    Clue clue(BoardLocation location) {
        return clues.get(location)
    }

    boolean visited(BoardLocation location) {
        return location in visitedLocations
    }

    void visit(BoardLocation location) {
        currentLocation = location
        visitedLocations.add(location)
    }

    BoardLocation nextLocation() {
        return clue(currentLocation).toLocation()
    }

    boolean treasureFound() {
        return clue(currentLocation).toLocation() == currentLocation
    }

    List<BoardLocation> visitedLocations() {
        return new ArrayList<BoardLocation>(visitedLocations).asUnmodifiable()
    }

    int numberOfClues() {
        return clues.size()
    }
}
