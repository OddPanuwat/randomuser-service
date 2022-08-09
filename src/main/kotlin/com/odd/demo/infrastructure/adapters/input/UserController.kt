package com.odd.demo.infrastructure.adapters.input

import com.odd.demo.domaim.model.Response
import com.odd.demo.domaim.service.UserServiceImpl
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api")
@EnableCaching
class UserController(val userService: UserServiceImpl) {

    @GetMapping()
    fun randomUser(): Mono<Response> {
        return userService.getRandomUser()
    }

    @GetMapping("/")
    fun randomUserBySeed(@RequestParam(name = "seed") seed: String): Mono<Response> {
        return userService.getRandomUserBySeed(seed)
    }
}
