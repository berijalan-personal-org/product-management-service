package com.batch14.product_management_service.controller

import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.service.MasterProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/product")
class ProductController (
    private val masterProductService: MasterProductService
){
    @GetMapping("/all")
    fun getAllProduct(): ResponseEntity<List<ResProductDto>> {
        return ResponseEntity.ok(masterProductService.getAllProduct())
    }

    @GetMapping("/{id}")
    fun getProductById(id: Int): ResponseEntity<ResProductDto> {
        return ResponseEntity.ok(masterProductService.getProductById(id))
    }
}