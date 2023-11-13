package ag.freenet.mealplannerservice.repository;

import ag.freenet.mealplannerservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
