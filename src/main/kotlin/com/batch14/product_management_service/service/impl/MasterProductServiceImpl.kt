package com.batch14.product_management_service.service.impl

import com.batch14.product_management_service.domain.dto.request.ReqProductDto
import com.batch14.product_management_service.domain.dto.response.ResProductDto
import com.batch14.product_management_service.domain.entity.MasterProductEntity
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
        val createdBies = rawData.map { it.createdBy }.toList()
        val users = userManagementClient.getAllUsersByIds(
            createdBies.toList() as List<Int>
        ).body!!.data!!
        val userMap = users.associateBy { it.id }
        val result = mutableListOf<ResProductDto>()
        rawData.forEach { product ->
            result.add(
                ResProductDto(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    stock = product.stock,
                    categoryId = product.category?.id,
                    categoryName = product.category?.category,
                    createdBy = userMap[product.createdBy]?.username ?: ""
                )
            )
        }
        return result
    }

    override fun getProductById(id: Int): ResProductDto {
        val product = masterProductRepository.getProductById(id)
        println(product?.createdBy)
        var createdBy = product?.createdBy
        var createdByName = ""
        if (createdBy != null) {// error ketika userManagementClient null
            val user = userManagementClient.findUserById(
                createdBy.toInt()
            ).body!!.data!!
            //val data: T? = null expected data data harus ada dengan !!
            println("Usernya: $user")
            createdByName = user.username
        }

        return product?.let {
            ResProductDto(
                id = it.id,
                name = it.name,
                price = it.price,
                stock = it.stock,
                categoryId = it.category?.id,
                categoryName = it.category?.category,
                createdBy = createdByName
            )
        } ?: throw Exception("Product tidak ditemukan")
    }

    override fun createProduct(product: MasterProductEntity): ReqProductDto {
        val category = masterCategoryRepository.findById(product.category!!.id).get()
        product.category = category
        val savedProduct = masterProductRepository.save(product)
        return ReqProductDto(
            name = savedProduct.name,
            price = savedProduct.price,
            categoryId = savedProduct.category?.id
        )
    }

    override fun getAllProductByIds(ids: List<Int>): List<ResProductDto> {
        val products = masterProductRepository.getAllProductByIds(ids)
        return products.map {
            ResProductDto(
                id = it.id,
                name = it.name,
                price = it.price,
                stock = it.stock,
                categoryId = it.category?.id,
                categoryName = it.category?.category,
                createdBy = ""
            )
        }
    }
}