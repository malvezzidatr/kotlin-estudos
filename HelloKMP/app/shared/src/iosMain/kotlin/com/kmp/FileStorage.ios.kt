package com.kmp
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.*

actual class FileStorage actual constructor(fileName: String) {
    private val path: String = NSSearchPathForDirectoriesInDomains(
        NSDocumentDirectory, NSUserDomainMask, true
    ).first() as String

    actual fun write(data: String) {
        (data as NSString).writeToFile(path, true)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun read(): String {
        return NSString.stringWithContentsOfFile(path, NSUTF8StringEncoding, null) as String
    }
}