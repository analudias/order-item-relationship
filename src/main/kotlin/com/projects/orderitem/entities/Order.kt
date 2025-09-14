package com.projects.orderitem.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "tb_order")
data class Order(
    @Id
    val id: UUID = UUID.randomUUID(),
    val orderDate: Date = Date(),
    val customerName: String,
    val amount: BigDecimal = BigDecimal.ZERO,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orderItens: MutableList<OrderItem> = mutableListOf()
) {
    fun updateOrderTotal(total: BigDecimal): Order {
        return this.copy(amount = total)
    }
}