package com.netlight.svti_backend_tommy.mappers

import com.netlight.svti_backend_tommy.StarshipListingDto
import com.netlight.svti_backend_tommy.db.entities.Starship
import org.springframework.stereotype.Component

@Component
class StarshipMapper {
    fun mapToListingDto(starship: Starship) = StarshipListingDto(
        id = starship.id!!,
        name = starship.name,
        imageUrl = "${starship.url}.jpg"
    )
}