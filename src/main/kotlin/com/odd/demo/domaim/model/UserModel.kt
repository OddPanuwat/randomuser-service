package com.odd.demo.domaim.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.io.Serializable

@Data
data class User(
    var gender: String?,
    var name: Name?,
    var location: Location?,
    var email: String?,
    var dob: Dob?,
) : Serializable

@Data
data class Location(
    var street: Street,
    var city: String?,
    var state: String?,
    var country: String?,
    var postcode: String?,
    var coordinates: Coordinates?,
    var timezone: Timezone?,
) : Serializable

@Data
data class Street(
    var number: Int?,
    var name: String?,
) : Serializable

@Data
data class Coordinates(
    var latitude: String?,
    var longitude: String?,
) : Serializable

@Data
data class Timezone(
    var offset: String?,
    var description: String?,
) : Serializable

@Data
data class Name(var title: String, var first: String, var last: String) : Serializable

@Data
data class Dob(var date: String, var age: Int) : Serializable

@Data
data class Info(@Id val seed: String, val results: Int, val page: Int, val version: String) : Serializable

@Data
@RedisHash("user")
data class Response(val results: List<User>, val info: Info) : Serializable