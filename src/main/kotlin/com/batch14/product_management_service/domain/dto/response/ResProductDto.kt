package com.batch14.product_management_service.domain.dto.response

data class ResProductDto(
    val id: Int,
    val name: String,
    val price: Int,
    val stock: Int,
    val categoryId: Int?,
    val categoryName: String?,
    val createdBy: String?
)
