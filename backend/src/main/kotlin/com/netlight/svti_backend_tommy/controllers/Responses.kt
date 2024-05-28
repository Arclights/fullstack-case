package com.netlight.svti_backend_tommy.controllers

import org.springframework.data.domain.Page

data class PaginationResponse<T>(
    val items: List<T>,
    val pageNumber: Int,
    val pageSize: Int,
    val totalPages: Int
) {
    companion object {
        fun <T> fromPage(page: Page<T>) = PaginationResponse(
            items = page.toList(),
            pageNumber = page.number,
            pageSize = page.size,
            totalPages = page.totalPages
        )
    }
}