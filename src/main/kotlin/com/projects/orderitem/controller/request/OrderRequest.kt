package com.projects.orderitem.controller.request

import com.projects.orderitem.entities.Order
import com.projects.orderitem.entities.OrderItem

data class OrderRequest(
    val customerName: String,
    val orderItens: MutableList<OrderItemRequest>
)

fun OrderRequest.toEntity(): Order {
    val order = Order(customerName = this.customerName)

    val items = this.orderItens.map {
        OrderItem(
            productName = it.productName,
            quantity = it.quantity,
            price = it.price,
            order = order
        )
    }.toMutableList()

    order.orderItens.addAll(items)

    return order

}