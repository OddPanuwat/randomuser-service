package com.odd.demo.app.ports.input

import com.odd.demo.domaim.model.Response
import reactor.core.publisher.Mono

interface RandomUserInputPort {
    fun getRandomUser(): Mono<Response>
    fun getRandomUserBySeed(seed: String): Mono<Response>
}