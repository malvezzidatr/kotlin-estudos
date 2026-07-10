package com.kmp

import android.content.Context
import java.io.FileOutputStream

actual class FileStorage actual constructor(val fileName: String) {
    private val context: Context = TODO();

    actual fun write(data: String) {
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use { it.write(data.toByteArray()) }
    }

    actual fun read(): String {
        TODO("Not yet implemented")
    }
}