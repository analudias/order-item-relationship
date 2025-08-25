package com.projects.orderitem.controller.response

import com.projects.orderitem.entities.Order
import java.util.Date
import java.util.UUID

data class OrderResponse(
    val id: UUID = UUID.randomUUID(),
    val orderDate: Date,
    val customerName: String,
    val orderItens: MutableList<OrderItemResponse>
)

fun Order.toResponse() = OrderResponse(
        id = this.id,
        orderDate = this.orderDate,
        customerName = this.customerName,
        orderItens = this.orderItens.map {
            OrderItemResponse(
                id = it.id,
                productName = it.productName,
                quantity = it.quantity,
                price = it.price
            )
        }.toMutableList()
    )
