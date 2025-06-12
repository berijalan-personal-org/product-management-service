package com.batch14.product_management_service.domain.dto.request

data class ReqProductDto(
    val name: String,
    val price: Int,
    val categoryId: Int
)
