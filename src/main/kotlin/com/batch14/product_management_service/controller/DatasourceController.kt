package com.batch14.product_management_service.controller

import com.batch14.product_management_service.domain.dto.response.BaseResponse
import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.service.MasterProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/datasource")
class DatasourceController (
    private val masterProductService: MasterProductService
){
    @GetMapping("/product/by-ids")
    fun getAllUsersByIds(
        @RequestParam(required = true) ids: List<Int>
    ): ResponseEntity<BaseResponse<List<ResProductDto>>> {
        return ResponseEntity.ok(
            BaseResponse(
                data = masterProductService.getAllProductByIds(ids)
            )
        )
    }
}