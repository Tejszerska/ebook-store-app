package pl.ebookstore.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.model.Address;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private BigDecimal totalCost;
    private LocalDate orderDate;
    private Address address; // używamy gdy kupno bez logowania/rejestracji

    public Purchase(Long id, Customer customer, BigDecimal totalCost, LocalDate orderDate) {
        this.id = id;
        this.customer = customer;
        this.totalCost = totalCost;
        this.orderDate = orderDate;
    }

    public Purchase(Long id, BigDecimal totalCost, LocalDate orderDate, Address address) {
        this.id = id;
        this.totalCost = totalCost;
        this.orderDate = orderDate;
        this.address = address;
    }
}
