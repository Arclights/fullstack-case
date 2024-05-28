package com.netlight.svti_backend_tommy.db

import com.netlight.svti_backend_tommy.db.entities.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface VehicleRepository : JpaRepository<Vehicle, UUID> {
    fun findAllByUrlIn(urls: List<String>): List<Vehicle>
}