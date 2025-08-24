package com.projects.orderitem.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "tb_order")
data class Order(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val customerName: String,

    @OneToMany
    @JoinColumn(name = "order_id")
    val orderItens: MutableList<OrderItem> = mutableListOf()
)