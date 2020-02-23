package com.kkisiele.treasure.oop

class Treasure {
    private final BoardRepository boardRepository

    Treasure(File file) {
        this(new TextFileBoardRepository(file))
    }

    Treasure(BoardRepository boardRepository) {
        this.boardRepository = boardRepository
    }

    List<BoardLocation> hunt(Clue startingClue) {
        def board = boardRepository.get()

        BoardLocation location = startingClue.toLocation()
        while (!board.visited(location)) {
            board.visit(location)
            if (board.hasTreasure()) {
                return board.visitedLocations()
            }
            location = board.nextLocation()
        }

        return []
    }
}
