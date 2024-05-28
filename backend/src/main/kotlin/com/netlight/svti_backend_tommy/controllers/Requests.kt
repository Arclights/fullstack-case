package com.netlight.svti_backend_tommy.controllers

import org.springframework.data.domain.PageRequest

data class PaginationRequest(
    val pageNumber: Int = 0,
    val pageSize: Int = 10
) {
    fun toPageable() = PageRequest.of(pageNumber, pageSize)
}