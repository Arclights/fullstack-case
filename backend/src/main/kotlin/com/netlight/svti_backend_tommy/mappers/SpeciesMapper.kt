package com.netlight.svti_backend_tommy.mappers

import com.netlight.svti_backend_tommy.SpecieListingDto
import com.netlight.svti_backend_tommy.db.entities.Specie
import org.springframework.stereotype.Component

@Component
class SpeciesMapper {
    fun mapToListingDto(specie: Specie) = SpecieListingDto(
        id = specie.id!!,
        name = specie.name,
        imageUrl = "${specie.url}.jpg"
    )
}