package pl.ebookstore.app.model.dtos;

import lombok.*;
import pl.ebookstore.app.entities.Purchase;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.enums.DeliveryType;
import pl.ebookstore.app.model.enums.Role;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String email;
    private String password; //@TODO ogarniamy 10.06
    private Address address;
    private String role;
    private String deliveryType;
    private List<Purchase> pastPurchases;
}
