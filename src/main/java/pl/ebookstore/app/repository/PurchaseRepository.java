package pl.ebookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ebookstore.app.entities.Purchase;
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
