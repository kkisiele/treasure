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
}
