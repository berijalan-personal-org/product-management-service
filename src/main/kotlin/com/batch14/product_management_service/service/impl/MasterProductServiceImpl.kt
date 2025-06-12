package com.batch14.product_management_service.service.impl

import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.repository.MasterCategoryRepository
import com.batch14.product_management_service.repository.MasterProductRepository
import com.batch14.product_management_service.service.MasterProductService
import org.springframework.stereotype.Service

@Service
class MasterProductServiceImpl (
    private val masterProductRepository: MasterProductRepository,
    private val masterCategoryRepository: MasterCategoryRepository
): MasterProductService {
    override fun getAllProduct(): List<ResProductDto> {
        val rawData = masterProductRepository.findAll()
        val result = mutableListOf<ResProductDto>()
        rawData.forEach { it ->
            result.add(
                ResProductDto(
                    id = it.id,
                    name = it.name,
                    price = it.price,
                    stock = it.stock,
                    categoryId = it.category?.id,
                    categoryName = it.category?.category

                )
            )
        }
        return result
    }

    override fun getProductById(id: Int): ResProductDto {
        val product = masterProductRepository.getProductById(id)
        return product?.let {
            ResProductDto(
                id = it.id,
                name = it.name,
                price = it.price,
                stock = it.stock,
                categoryId = it.category?.id,
                categoryName = it.category?.category
            )
        } ?: throw Exception("Product tidak ditemukan")
    }
}