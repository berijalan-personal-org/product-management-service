package com.batch14.product_management_service.service

import com.batch14.product_management_service.domain.dto.request.ReqProductDto
import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.domain.entity.MasterProductEntity

interface MasterProductService {
    fun getAllProduct(): List<ResProductDto>
    fun getProductById(id: Int): ResProductDto
    fun createProduct(product: MasterProductEntity): ReqProductDto
    fun getAllProductByIds(ids: List<Int>): List<ResProductDto>
}