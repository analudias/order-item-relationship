package com.projects.orderitem.controller

import com.projects.orderitem.controller.request.OrderRequest
import com.projects.orderitem.controller.response.OrderResponse
import com.projects.orderitem.services.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(
    val orderService: OrderService
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<OrderResponse> = orderService.findAll()

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveOrder(@RequestBody orderRequest: OrderRequest): OrderResponse {
        return orderService.saveOrder(orderRequest)
    }
}