package com.batch14.product_management_service.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Entity
@Table(name="mst_products")
data class MasterProductEntity(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "mst_products_id_seq"
    )
    @SequenceGenerator(
        name = "mst_products_id_seq",
        sequenceName = "mst_products_id_seq",
        allocationSize = 1
    )
    @Column(name="id", insertable = false, updatable = false)
    val id: Int = 0,

    @Column(name="name", nullable = false)
    val name: String,

    @Column(name="price", nullable = false)
    val price: Int,

    @Column(name="stock", nullable = false)
    val stock: Int,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id") //kolom yang mengaitkan di user
    var role: MasterCategoryEntity? = null,

    @CreationTimestamp
    @Column(name="created_at", insertable = false, updatable = false) //karena current jadi false saja
    var createdAt: Timestamp? = null,

    @Column(name="created_by")
    var createdBy: String? = null,

    @UpdateTimestamp
    @Column(name="updated_at", insertable = false, updatable = false) //karena current jadi false saja
    var updatedAt: Timestamp? = null,

    @Column(name="updated_by")
    var updatedBy: String? = null,

    @Column(name="deleted_at", insertable = false, updatable = false) //karena current jadi false saja
    var deletedAt: Timestamp? = null,

    @Column(name="deleted_by")
    var deletedBy: String? = null,

    @Column(name="is_active")
    var isActive: Boolean = true,

    @Column(name="is_delete")
    var isDelete: Boolean = false
)
