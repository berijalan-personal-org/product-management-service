package com.batch14.product_management_service.service

import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.domain.entity.MasterProductEntity

interface MasterProductService {
    fun getAllProduct(): List<ResProductDto>
    fun getProductById(id: Int): ResProductDto
}