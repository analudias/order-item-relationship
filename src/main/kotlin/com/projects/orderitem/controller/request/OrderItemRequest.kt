package com.projects.orderitem.controller.request

import java.math.BigDecimal

data class OrderItemRequest(
    val productName: String,
    val quantity: Int,
    val price: BigDecimal
)
