package com.netlight.svti_backend_tommy.mappers

import com.netlight.svti_backend_tommy.CharacterDetailsDto
import com.netlight.svti_backend_tommy.CharacterListingDto
import com.netlight.svti_backend_tommy.db.entities.Character
import org.springframework.stereotype.Component

@Component
class CharacterMapper(
    private val planetMapper: PlanetMapper,
    private val filmMapper: FilmMapper,
    private val speciesMapper: SpeciesMapper,
    private val starshipMapper: StarshipMapper,
    private val vehicleMapper: VehicleMapper
) {
    fun mapToListingDto(character: Character) = CharacterListingDto(
        id = character.id!!,
        name = character.name,
        imageUrl = "${character.url}.jpg"
    )

    fun mapToDetailsDto(character: Character) = CharacterDetailsDto(
        id = character.id!!,
        name = character.name,
        height = character.height,
        mass = character.mass,
        hairColor = character.hairColor,
        skinColor = character.skinColor,
        eyeColor = character.eyeColor,
        birthYear = character.birthYear,
        gender = character.gender,
        imageUrl = "${character.url}.jpg",
        homeworld = character.homeworld?.let(planetMapper::mapToListingDto),
        films = character.films.map(filmMapper::mapToListingDto),
        species = character.species.map(speciesMapper::mapToListingDto),
        starships = character.starships.map(starshipMapper::mapToListingDto),
        vehicles = character.vehicles.map(vehicleMapper::mapToListingDto),

        )
}