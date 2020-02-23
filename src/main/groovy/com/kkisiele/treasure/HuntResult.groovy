package com.kkisiele.treasure

class HuntResult {
    String status
    List<String> visitedCells

    static HuntResult found(List<String> visitedCells) {
        return create("FOUND TREASURE", visitedCells)
    }

    static HuntResult notFound() {
        return create("NO TREASURE")
    }

    static HuntResult error(String message) {
        return create("ERROR - ${message}")
    }

    private static HuntResult create(String status, List<String> visitedCells = []) {
        def huntResult = new HuntResult()
        huntResult.status = status
        huntResult.visitedCells = visitedCells
        return huntResult
    }

    HuntResult() {
    }
}
