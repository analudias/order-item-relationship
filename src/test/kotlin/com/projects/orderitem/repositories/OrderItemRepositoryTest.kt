package com.projects.orderitem.repositories

import com.projects.orderitem.entities.Order
import com.projects.orderitem.entities.OrderItem
import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import kotlin.test.Test

@DataJpaTest
@Transactional
@ActiveProfiles("test")
class OrderItemRepositoryTest(
    @Autowired val orderRepository: OrderRepository,
    @Autowired val orderItemRepository: OrderItemRepository
) {
    @Test
    fun `should sum order items by order id`() {
        val order = Order(customerName = "Carla")

        val item1 = OrderItem(
            productName = "Produto X",
            quantity = 2,
            price = BigDecimal.valueOf(10.0),
            order = order
        )

        val item2 = OrderItem(
            productName = "Produto Y",
            quantity = 1,
            price = BigDecimal.valueOf(5.0),
            order = order
        )

        val expectedTotal = (item1.price * BigDecimal.valueOf(item1.quantity.toLong())) +
                (item2.price * BigDecimal.valueOf(item2.quantity.toLong()))

        order.orderItens.addAll(listOf(item1, item2))

        val savedOrder = orderRepository.save(order)

        val total = orderItemRepository.sumByOrderId(savedOrder.id)

        assertThat(total).isEqualByComparingTo(expectedTotal)
    }
}