package ekart.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ekart.order.entity.MyKey;
import ekart.order.entity.ProductsOrdered;

public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, MyKey>{

	
	List<ProductsOrdered> findByORDERID(int ORDERID);

}
