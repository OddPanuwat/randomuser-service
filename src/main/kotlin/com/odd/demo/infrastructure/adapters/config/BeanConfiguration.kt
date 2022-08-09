package com.odd.demo.infrastructure.adapters.config

import com.odd.demo.infrastructure.adapters.output.RandomUserAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeanConfiguration {
    @Bean
    fun randomUserAdapter(): RandomUserAdapter {
        return RandomUserAdapter()
    }


}