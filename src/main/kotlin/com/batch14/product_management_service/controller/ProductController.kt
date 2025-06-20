package com.batch14.product_management_service.controller

import com.batch14.product_management_service.domain.dto.request.ReqProductDto
import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.domain.entity.MasterProductEntity
import com.batch14.product_management_service.service.MasterProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
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
    fun getProductById(
        @PathVariable id: Int
    ): ResponseEntity<ResProductDto> {
        val product = masterProductService.getProductById(id)
        return ResponseEntity.ok(product)
    }

    @PostMapping("/create")
    fun createProduct(product: MasterProductEntity): ResponseEntity<ReqProductDto?> {
        val createdProduct = masterProductService.createProduct(product)
        return ResponseEntity.ok(createdProduct)
    }
}