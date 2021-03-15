package ekart.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ekart.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<ProductsOrdered> findByOrderId(int ORDERID);
}
