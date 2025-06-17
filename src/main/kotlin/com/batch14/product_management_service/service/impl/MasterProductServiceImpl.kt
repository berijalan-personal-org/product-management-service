package com.batch14.product_management_service.service.impl

import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.repository.MasterCategoryRepository
import com.batch14.product_management_service.repository.MasterProductRepository
import com.batch14.product_management_service.rest.UserManagementClient
import com.batch14.product_management_service.service.MasterProductService
import org.springframework.stereotype.Service

@Service
class MasterProductServiceImpl (
    private val masterProductRepository: MasterProductRepository,
    private val masterCategoryRepository: MasterCategoryRepository,
    private val userManagementClient: UserManagementClient
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
                    categoryName = it.category?.category,
                    createdBy = it.createdBy
                )
            )
        }
        return result
    }

    override fun getProductById(id: Int): ResProductDto {
        val product = masterProductRepository.getProductById(id)
        println(product?.createdBy)
        var createdBy = product?.createdBy

        if (createdBy != null) {// error ketika userManagementClient null
            val user = userManagementClient.findUserById(
                createdBy.toInt()
            ).body!!.data!!
            //val data: T? = null expected data data harus ada dengan !!
            println("Usernya: $user")
            createdBy = user?.username
        }

        return product?.let {
            ResProductDto(
                id = it.id,
                name = it.name,
                price = it.price,
                stock = it.stock,
                categoryId = it.category?.id,
                categoryName = it.category?.category,
                createdBy = createdBy
            )
        } ?: throw Exception("Product tidak ditemukan")
    }
}