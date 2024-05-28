package com.netlight.svti_backend_tommy.db

import com.netlight.svti_backend_tommy.db.entities.Film
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface FilmRepository : JpaRepository<Film, UUID> {
    fun findAllByUrlIn(urls: List<String>): List<Film>
}