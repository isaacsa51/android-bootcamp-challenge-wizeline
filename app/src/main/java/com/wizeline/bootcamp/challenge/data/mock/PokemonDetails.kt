package com.wizeline.bootcamp.challenge.data.mock

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDetails(
    @Json(name = "abilities") val abilities: List<Ability>,
    @Json(name = "height") val height: Double,
    @Json(name = "weight") val weight: Double,
    @Json(name = "name") val name: String,
    @Json(name = "sprites") val sprites: Sprites,
)


@JsonClass(generateAdapter = true)
data class Ability(
    @Json(name = "ability") val abilityDetail: AbilityDetail,
)

@JsonClass(generateAdapter = true)
data class AbilityDetail(
    @Json(name = "name") val name: String,
)

@JsonClass(generateAdapter = true)
data class Sprites(
    @Json(name = "front_default") val frontDefault: String,
    @Json(name = "back_default") val backDefault: String,
)
