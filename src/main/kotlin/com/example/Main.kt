package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.time.LocalDate

@SpringBootApplication
class Main

fun main() {
    val context = AnnotationConfigApplicationContext(AppConfig::class.java)
    val phoneContainer = context.getBean(Container::class.java) as PhoneContainer

    val pixel7Files = listOf(
        StorageFile("bootloader", "bin", 250000.0, LocalDate.of(2023, 5, 20), false),
        StorageFile("cat", "png", 1900.0, LocalDate.of(2022, 1, 10), true),
        StorageFile("kpi_logo", "jpg", 2200.0, LocalDate.of(2010, 2, 8), true),
    )

    val onePlus9ProFiles = listOf(
        StorageFile("gcam", "apk", 200000.0, LocalDate.of(2023, 2, 13), false),
        StorageFile("trojan", "apk", 51000.0, LocalDate.of(2022, 10, 27), false),
        StorageFile("kpi_logo", "jpg", 2200.0, LocalDate.of(2010, 2, 8), true),
    )

    phoneContainer.add(
        Phone(
            "Google",
            "USA",
            "Pixel 7",
            128,
            430,
            LocalDate.of(2022, 6, 20),
            false,
            pixel7Files
        ),
    )

    phoneContainer.add(
        Phone(
            "OnePlus",
            "China",
            "9 Pro",
            256,
            650,
            LocalDate.of(2021, 12, 5),
            true,
            onePlus9ProFiles
        ),
    )
}
