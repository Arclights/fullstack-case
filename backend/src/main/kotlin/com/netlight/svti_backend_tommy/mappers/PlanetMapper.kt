package com.netlight.svti_backend_tommy.mappers

import com.netlight.svti_backend_tommy.PlanetListingDto
import com.netlight.svti_backend_tommy.db.entities.Planet
import org.springframework.stereotype.Component

@Component
class PlanetMapper {
    fun mapToListingDto(planet: Planet) = PlanetListingDto(
        id = planet.id!!,
        name = planet.name,
        imageUrl = "${planet.url}.jpg"
    )
}