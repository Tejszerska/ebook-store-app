package pl.ebookstore.app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.entities.Purchase;
import pl.ebookstore.app.model.Address;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPurchaseDto {
    private String email;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String role;
    private BigDecimal totalCost; // przekazac z podsumowania koszyka
    private LocalDate orderDate;
    private String deliveryType;
}
