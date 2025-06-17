package com.batch14.product_management_service.rest

import com.batch14.product_management_service.domain.dto.response.BaseResponse
import com.batch14.product_management_service.domain.dto.response.ResUserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    "user-management-service",
    path = "/user-service")
interface UserManagementClient {
    @GetMapping("/v1/users/{id}")
    fun findUserById(
        @PathVariable id: Int
    ): ResponseEntity<BaseResponse<ResUserDto>>
}