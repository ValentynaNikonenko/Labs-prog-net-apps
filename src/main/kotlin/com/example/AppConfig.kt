package com.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AppConfig {
    @Bean
    open fun phoneContainer(): PhoneContainer {
        return PhoneContainer()
    }
}