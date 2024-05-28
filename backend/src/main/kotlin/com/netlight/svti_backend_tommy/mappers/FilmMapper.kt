package com.netlight.svti_backend_tommy.mappers

import com.netlight.svti_backend_tommy.FilmListingDto
import com.netlight.svti_backend_tommy.db.entities.Film
import org.springframework.stereotype.Component

@Component
class FilmMapper {
    fun mapToListingDto(film: Film) = FilmListingDto(
        id = film.id!!,
        title = film.title,
        episode = film.episodeId,
        imageUrl = "${film.url}.jpg"
    )
}