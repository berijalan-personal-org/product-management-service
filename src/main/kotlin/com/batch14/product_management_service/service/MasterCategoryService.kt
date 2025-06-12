package com.batch14.product_management_service.service

import com.batch14.product_management_service.domain.dto.response.ResCategoryDto
import com.batch14.product_management_service.domain.entity.MasterCategoryEntity

interface MasterCategoryService {
    fun getAllCategory(): List<ResCategoryDto>
}