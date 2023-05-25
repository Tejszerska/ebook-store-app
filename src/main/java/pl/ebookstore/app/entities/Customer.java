package pl.ebookstore.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.DeliveryType;
import pl.ebookstore.app.model.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password; //@TODO zapytać R.
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    @OneToMany (mappedBy = "customer")
    private List <Purchase> pastPurchases;
}
