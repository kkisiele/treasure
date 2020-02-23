package com.kkisiele.treasure

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

import javax.inject.Inject

@CompileStatic
@Controller("/")
class TreasureController {
    @Inject
    private TreasureFacade facade

    @Get
    HuntResult hunt(@QueryValue(value = "clue", defaultValue = "11") String clue) {
        try {
            List<String> visitedCells = facade.findTreasure(clue)
            return visitedCells ? HuntResult.found(visitedCells) : HuntResult.notFound()
        } catch (ValidatorException ex) {
            return HuntResult.error(ex.getMessage())
        }
    }

    private static class HuntResult {
        final String status
        final List<String> visitedCells

        static HuntResult found(List<String> visitedCells) {
            return new HuntResult("FOUND TREASURE", visitedCells)
        }

        static HuntResult notFound() {
            return new HuntResult("NO TREASURE")
        }

        static HuntResult error(String message) {
            return new HuntResult("ERROR - ${message}")
        }

        private HuntResult(String status, List<String> visitedCells = []) {
            this.status = status
            this.visitedCells = visitedCells
        }
    }
}
