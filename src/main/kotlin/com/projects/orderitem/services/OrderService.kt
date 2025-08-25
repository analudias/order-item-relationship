package com.projects.orderitem.services

import com.projects.orderitem.controller.request.OrderRequest
import com.projects.orderitem.controller.request.toEntity
import com.projects.orderitem.controller.response.OrderResponse
import com.projects.orderitem.controller.response.toResponse
import com.projects.orderitem.repositories.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService (
    val orderRepository: OrderRepository
){
    fun findAll(): List<OrderResponse> {
        return orderRepository.findAll().map { it.toResponse() }
    }

    fun saveOrder(orderRequest: OrderRequest): OrderResponse {
        val orders = orderRequest.toEntity()
        return orderRepository.save(orders).toResponse()
    }
}