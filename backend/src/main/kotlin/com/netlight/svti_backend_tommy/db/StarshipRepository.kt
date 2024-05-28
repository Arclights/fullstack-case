package com.netlight.svti_backend_tommy.db

import com.netlight.svti_backend_tommy.db.entities.Starship
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StarshipRepository : JpaRepository<Starship, UUID> {
    fun findAllByUrlIn(urls: List<String>): List<Starship>
}