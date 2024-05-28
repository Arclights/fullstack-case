package com.netlight.svti_backend_tommy

import java.util.UUID

data class CharacterListingDto(
    val id: UUID,
    val name: String,
    val imageUrl: String
)

data class CharacterDetailsDto(
    val id: UUID,
    val name: String,
    val height: Int,
    val mass: Int,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val imageUrl: String,
    val homeworld: PlanetListingDto?,
    val films: List<FilmListingDto>,
    val species: List<SpecieListingDto>,
    val starships: List<StarshipListingDto>,
    val vehicles: List<VehicleListingDto>
)

data class FilmListingDto(
    val id: UUID,
    val title: String,
    val episode: Int,
    val imageUrl: String
)

data class PlanetListingDto(
    val id: UUID,
    val name: String,
    val imageUrl: String
)

data class SpecieListingDto(
    val id: UUID,
    val name: String,
    val imageUrl: String
)

data class StarshipListingDto(
    val id: UUID,
    val name: String,
    val imageUrl: String
)

data class VehicleListingDto(
    val id: UUID,
    val name: String,
    val imageUrl: String
)