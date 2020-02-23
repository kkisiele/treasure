package com.kkisiele.treasure

class TestFile {
    static File get() {
        return new File(getClass().getResource("/test_input.txt").file)
    }
}
