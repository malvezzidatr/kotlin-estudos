package com.kmp

import java.io.File

actual class FileStorage actual constructor(fileName: String) {
    private val file = File(fileName);

    actual fun write(data: String) {
        file.writeText(data);
    }

    actual fun read(): String {
        return file.readText();
    }
}