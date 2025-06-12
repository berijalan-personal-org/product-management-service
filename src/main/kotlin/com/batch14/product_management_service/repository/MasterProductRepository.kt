package com.batch14.product_management_service.repository

import com.batch14.product_management_service.domain.entity.MasterProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface MasterProductRepository: JpaRepository<MasterProductEntity, Int>{
    @Query("""
        SELECT U FROM MasterUserEntity U
        LEFT JOIN FETCH U.category
        WHERE U.isDelete = false
        AND U.isActive = true
    """, nativeQuery = false)
    fun getAllActiveUser(): List<MasterProductEntity>

    @Query("""
        SELECT U FROM MasterProductEntity U
        LEFT JOIN FETCH U.category
        WHERE U.isDelete = false
        AND U.isActive = true
        AND U.id = :id
    """, nativeQuery = false)
    fun getProductById(@Param("id") id: Int): MasterProductEntity?
}