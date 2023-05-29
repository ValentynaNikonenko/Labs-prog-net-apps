package com.example

import java.time.LocalDate

data class Phone(
    val brand: String,
    val manufacturer: String,
    val model: String,
    val rom: Int,
    val price: Int,
    val releaseDate: LocalDate,
    val doubleSIMSupport: Boolean,
    val files: List<StorageFile>
) : Comparable<Phone> {
    override fun compareTo(phone: Phone): Int {
        val compare = model.compareTo(phone.model)
        if (compare != 0) {
            if (brand.compareTo(phone.brand) != 0)
                return -1
            if (manufacturer.compareTo(phone.manufacturer) != 0)
                return -1
            if (releaseDate.compareTo(phone.releaseDate) != 0)
                return -1
        }
        return 0
    }
}