package com.projects.orderitem.repositories

import com.projects.orderitem.entities.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.util.UUID

@Repository
interface OrderItemRepository : JpaRepository<OrderItem, UUID> {

    @Query("SELECT COALESCE(SUM(oi.price * oi.quantity), 0) FROM OrderItem oi WHERE oi.order.id = :orderId")
    fun sumByOrderId(orderId: UUID): BigDecimal
}