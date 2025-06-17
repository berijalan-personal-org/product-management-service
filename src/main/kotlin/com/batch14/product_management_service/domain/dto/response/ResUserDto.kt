package com.batch14.product_management_service.domain.dto.response

data class ResUserDto(
    val id: Int,
    val email: String,
    val username: String,
    var roleId: Int?,
    var roleName: String? = null
)
