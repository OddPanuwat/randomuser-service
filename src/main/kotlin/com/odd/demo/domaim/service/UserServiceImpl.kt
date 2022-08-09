package com.odd.demo.domaim.service

import com.odd.demo.app.ports.input.RandomUserInputPort
import com.odd.demo.app.ports.output.RandomUserOutputPort
import com.odd.demo.domaim.model.Response
import lombok.AllArgsConstructor
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
@AllArgsConstructor
class UserServiceImpl(var randomUserOutputPort: RandomUserOutputPort) : RandomUserInputPort {

    private val reactiveRedisTemplate: ReactiveRedisTemplate<Response, String>? = null

    //@Cacheable(value = ["user"])
    override fun getRandomUser(): Mono<Response> {
        return randomUserOutputPort.getRandomUser()
    }

    //@Cacheable(value = ["user"], key = "#seed", unless = "#result==null")
//    @Cacheable(value = ["user"], key = "#seed")
    override fun getRandomUserBySeed(seed: String): Mono<Response> {
        println("Service getRandomUserBySeed")
        println("seed : $seed")
//        var resJson = randomUserOutputPort.getRandomUserBySeed(seed)
//        println(resJson.block())
        return randomUserOutputPort.getRandomUserBySeed(seed)
    }

}