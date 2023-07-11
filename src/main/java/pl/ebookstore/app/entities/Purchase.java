package pl.ebookstore.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.enums.DeliveryType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    @ManyToMany
    private List<Ebook> purchasedEbooks;

}
