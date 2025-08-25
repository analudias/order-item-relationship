package com.projects.orderitem.controller.request

data class OrderItemRequest(
    val productName: String,
    val quantity: Int,
    val price: Double
)
