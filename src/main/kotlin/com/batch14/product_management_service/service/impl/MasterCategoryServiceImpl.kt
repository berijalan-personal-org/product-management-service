package com.batch14.product_management_service.service.impl

import com.batch14.product_management_service.domain.dto.response.ResCategoryDto
import com.batch14.product_management_service.domain.entity.MasterCategoryEntity
import com.batch14.product_management_service.repository.MasterCategoryRepository
import com.batch14.product_management_service.service.MasterCategoryService
import org.springframework.stereotype.Service

@Service
class MasterCategoryServiceImpl (
    private val masterCategoryRepository: MasterCategoryRepository
): MasterCategoryService {
    override fun getAllCategory(): List<ResCategoryDto> {
        val categories = masterCategoryRepository.findAll()
        val result = mutableListOf<ResCategoryDto>()
        categories.forEach { category ->
            result.add(
                ResCategoryDto(
                    id = category.id,
                    category = category.category
                )
            )
        }
        return result
    }
}