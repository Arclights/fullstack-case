package com.netlight.svti_backend_tommy.db

import com.netlight.svti_backend_tommy.db.entities.Specie
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpecieRepository : JpaRepository<Specie, UUID> {
    fun findAllByUrlIn(urls: List<String>): List<Specie>
}