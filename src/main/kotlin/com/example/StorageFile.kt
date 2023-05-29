package com.example

import java.time.LocalDate

data class StorageFile(
    val name: String,
    val extension: String,
    val size: Double, // in kb
    val creationDate: LocalDate,
    val isPhoto: Boolean,
) : Comparable<StorageFile> {
    override fun compareTo(storageFile: StorageFile): Int {
        if (name.compareTo(storageFile.name) != 0)
            return -1
        if (creationDate.compareTo(storageFile.creationDate) != 0)
            return -1
        if (extension.compareTo(storageFile.extension) != 0)
            return -1
        if (size.compareTo(storageFile.size) != 0)
            return -1
        return 0
    }
}