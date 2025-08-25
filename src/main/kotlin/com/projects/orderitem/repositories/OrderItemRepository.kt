package com.projects.orderitem.repositories

import com.projects.orderitem.entities.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderItemRepository : JpaRepository<OrderItem, UUID>