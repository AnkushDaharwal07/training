package ekart.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ekart.order.entity.ProductsOrdered;

public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, Integer>{
	
	List<ProductsOrdered> getByORDERID(int ORDERID);

}
