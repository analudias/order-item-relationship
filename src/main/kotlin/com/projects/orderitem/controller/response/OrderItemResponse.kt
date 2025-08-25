package com.projects.orderitem.controller.response

import java.util.UUID

data class OrderItemResponse(
    val id: UUID = UUID.randomUUID(),
    val productName: String,
    val quantity: Int,
    val price: Double
)

