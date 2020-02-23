package com.kkisiele.treasure

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class TreasureControllerSpec extends Specification {
    @Inject
    @Client("/")
    RxHttpClient client

    def "Should return response with found treasure"() {
        when:
        def result = makeRequest("11")

        then:
        result.status == 'FOUND TREASURE'
        result.visitedCells.size() > 0
    }

    def "Should return response with not found treasure"() {
        when:
        def result = makeRequest("41")

        then:
        result.status == 'NO TREASURE'
    }

    def "Should return response with error"() {
        when:
        def result = makeRequest("WRONG")

        then:
        result.status.startsWith('ERROR')
    }

    private HuntResult makeRequest(String clue) {
        HttpRequest request = HttpRequest.GET("/?clue=$clue")
        return client.toBlocking().retrieve(request, HuntResult.class)
    }
}
