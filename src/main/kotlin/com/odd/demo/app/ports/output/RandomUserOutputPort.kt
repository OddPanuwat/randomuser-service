package com.odd.demo.app.ports.output

import com.odd.demo.domaim.model.Response
import reactor.core.publisher.Mono

interface RandomUserOutputPort {
    fun getRandomUser(): Mono<Response>
    fun getRandomUserBySeed(seed: String): Mono<Response>
}