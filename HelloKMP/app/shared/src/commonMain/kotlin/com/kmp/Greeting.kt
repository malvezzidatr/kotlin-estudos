package com.kmp

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return sayHello(platform.name)
    }

    fun writeDummyFile() {
        FileStorage("temp.txt").write("Hello there!")
    }
}