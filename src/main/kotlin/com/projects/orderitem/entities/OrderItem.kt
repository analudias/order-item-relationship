package com.projects.orderitem.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tb_order_item")
data class OrderItem(

    @Id
    val id: String = UUID.randomUUID().toString(),
    val productName: String,
    val quantity: Int,
    val price: Double
)
