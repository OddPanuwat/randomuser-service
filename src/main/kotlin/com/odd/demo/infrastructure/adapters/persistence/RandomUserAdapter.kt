package com.odd.demo.infrastructure.adapters.persistence

import com.google.gson.Gson
import com.odd.demo.app.ports.output.RandomUserOutputPort
import com.odd.demo.domaim.model.*
import lombok.RequiredArgsConstructor
import org.springframework.data.redis.connection.RedisServer.INFO
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono


@RequiredArgsConstructor
class RandomUserAdapter() : RandomUserOutputPort {
    private val client = WebClient.create("https://randomuser.me/api")

    override fun getRandomUser(): Mono<Response> {
        return client.get().retrieve().bodyToMono()
    }

    override fun getRandomUserBySeed(seed: String): Mono<Response> {
        var res = client.get().uri("?seed=$seed").retrieve().bodyToMono<Response>()
        res.map {r->  println(r) }.subscribe()
        return res
    }

}