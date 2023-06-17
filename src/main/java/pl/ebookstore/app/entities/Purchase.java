package pl.ebookstore.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.enums.DeliveryType;

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
//    private Address address; // używamy gdy kupno bez logowania/rejestracji
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

}
