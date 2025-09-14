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
class OrderRepositoryTest(
    @Autowired val orderRepository: OrderRepository,
    @Autowired val orderItemRepository: OrderItemRepository
) {

    @Test
    fun `Should persist order with its order items`() {
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

        order.orderItens.add(item1)
        order.orderItens.add(item2)

        val savedOrder = orderRepository.save(order)
        val savedItems = orderItemRepository.findAll()

        assertThat(savedItems).hasSize(2)
        val savedItem = savedItems[0]
        assertThat(savedItem.order).isNotNull
        assertThat(savedItem.order.id).isEqualTo(savedOrder.id)
    }
}
