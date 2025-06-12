package com.batch14.product_management_service.repository

import com.batch14.product_management_service.domain.entity.MasterCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
interface MasterCategoryRepository: JpaRepository<MasterCategoryEntity, Int> {

}