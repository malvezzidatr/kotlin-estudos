package com.kmp

expect class FileStorage(fileName: String) {
    fun write(data: String);
    fun read(): String;
}