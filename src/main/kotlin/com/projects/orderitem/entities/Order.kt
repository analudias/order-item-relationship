package com.projects.orderitem.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_order")
data class Order(
    @Id
    val id: UUID = UUID.randomUUID(),
    val orderDate: Date = Date(),
    val customerName: String,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orderItens: MutableList<OrderItem> = mutableListOf()
)