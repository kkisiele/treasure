package com.kkisiele.treasure

import groovy.transform.CompileStatic

@CompileStatic
class ValidatorException extends RuntimeException {
    ValidatorException(String message) {
        super(message)
    }
}
