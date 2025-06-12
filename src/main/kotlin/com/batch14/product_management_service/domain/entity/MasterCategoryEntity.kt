package com.batch14.product_management_service.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name="mst_categories")
data class MasterCategoryEntity(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "mst_categories_id_seq"
    )
    @SequenceGenerator(
        name = "mst_categories_id_seq",
        sequenceName = "mst_categories_id_seq",
        allocationSize = 1
    )
    @Column(name="id", insertable = false, updatable = false)
    val id: Int = 0,

    @Column(name="name", nullable = false)
    val name: String
)