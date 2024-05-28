package com.netlight.svti_backend_tommy.mappers

import com.netlight.svti_backend_tommy.VehicleListingDto
import com.netlight.svti_backend_tommy.db.entities.Vehicle
import org.springframework.stereotype.Component

@Component
class VehicleMapper {
    fun mapToListingDto(vehicle: Vehicle) = VehicleListingDto(
        id = vehicle.id!!,
        name = vehicle.name,
        imageUrl = "${vehicle.url}.jpg"
    )
}