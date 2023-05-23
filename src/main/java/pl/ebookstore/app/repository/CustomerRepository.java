package pl.ebookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ebookstore.app.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
