package com.batch14.product_management_service.controller

import com.batch14.product_management_service.domain.dto.response.ResCategoryDto
import com.batch14.product_management_service.service.MasterCategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/category")
class CategoryController (
    private val masterCategoryService: MasterCategoryService
){
    @GetMapping("/all")
    fun getAllCategory(): ResponseEntity<List<ResCategoryDto>>{
        return ResponseEntity.ok(
            masterCategoryService.getAllCategory()
        )
    }
}